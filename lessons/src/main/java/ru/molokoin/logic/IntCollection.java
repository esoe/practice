package ru.molokoin.logic;

/**
 * Реализация интерфейса булевого массива
 * Логические значения хранятся в битах массива целочисленных значений int
 */
public class IntCollection implements CollectionFace{
    int size = 1024;//размер булевого массива
    int box = 32;//количество бит выделенное под значение типа integer
    int[] collection = new int[size/box];//1024 (размер булевого массива)/32 (размер блока, для формирования интового значения)

    /**
     * index - варьирует от 0 до 1024 (весь булевский массив)
     * возвращает true, если в поле index содержится 1, или true
     * возвращает false, если в поле index содержится 0
     * TODO проверка границ index (0 --> 1023)
     */
    @Override
    public boolean isContain(int index) throws ArrayIndexOutOfBoundsException{
        /**
         * indexOfBox - порядковый номер бокса в булевом массиве
         * или индекс значения в интовом массиве
         */
        int indexOfBox = index/box;//результат целочисленного деления
        //порядковый номер бита в боксе
        int indexInBox = index%box;//остаток от деления
        /**
         * value - число, хранимое в интовом массиве, в битах которого зашифровано необходимое булевое значение
         * при переводе значения этого числа в двоичный код, будет получен массив битов,
         * где значение под номером indexInBox - будет искомое значение
         */
        int value = collection[indexOfBox];
        /**
         * Далее можно выводить в печать интовое значение, побитовое значение интового числа или обрабатывать  биты, хранимые в этом числе ...
         */
        /**
         * двигаем единичку в позицию, где находится искомый бит в боксе
         */
        int mask = 1 << indexInBox;
        /**
         * сравниваем интовое значение, преобразованное в двоичный код с маской
         * преобразование на сколько понимаю происходит автоматически.
         *  0 0 1 0 0 0 0 0 mask
         *  1 0 1 0 1 0 1 0 value
         * после операции "И" получаем
         *  0 0 1 0 0 0 0 0
         * далее идет сравнение с mask
         */
        Boolean result = ((value&mask) == mask);
        return result;
    }

    /**
     * 0 0 1 0 0 0 0 0 mask
     * 1 0 1 0 1 0 1 0 value
     * после операции "&" : "И" получаем
     * 0 0 1 0 0 0 0 0
     * после "|" : "ИЛИ" получаем
     * 1 0 1 0 1 0 1 0
     * после "^" : "xor" получаем
     * 1 0 0 0 1 0 1 0
     */
    @Override
    public void setTrueByIndex(int index) throws ArrayIndexOutOfBoundsException{
        //обработка исключений
        Boolean b = (index < 0)&(index > 1023);
        if(b){
            String msg = "";
            msg = msg + "Превышены границы массива, значение (index) должно быть:\n" +
                        "- меньше 1024 ..." + "\n" +
                        "- больше нуля ..." + "\n" +
                        "метод setTrueByIndex(int index)" + " к полю с индексом " + index + " не применен ...";
            throw new ArrayIndexOutOfBoundsException(msg);
        }
        //обработка значений массива
        try {
            if (isContain(index)){
                return;
            }else{
                int indexOfBox = index/box;
                int indexInBox = index%box;
                int value = collection[indexOfBox];
                int mask = 1 << indexInBox;
                /**
                 * не меняем значения value,
                 * кроме замаскированного поля и только в случае, если там 0
                 */
                value = value | mask;
                collection[indexOfBox] = value;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void setFalseByIndex(int index) throws ArrayIndexOutOfBoundsException{
        //обработка исключений
        Boolean b = (index < 0)&(index > 1023);
        if(b){
            String msg = "";
            msg = msg + "Превышены границы массива, значение (index) должно быть:\n" +
                        "- меньше 1024 ..." + "\n" +
                        "- больше нуля ..." + "\n" +
                        "метод setFalseByIndex(int index)" + " к полю с индексом " + index + " не применен ...";
            throw new ArrayIndexOutOfBoundsException(msg);
        }
        if (isContain(index) == false){
            return;
        }
        /**
         * в поле точно единица, которую надо заменить на 0, не меняя остальных значений в боксе.
         * - все значения сравниваются с нулями и должны в результате не измениться
         * - сравнивая единицу с единицей нужно получить ноль
         * или - не заменит единицу, сохранив остальные значения
         * и - не заменит единицу, затрет остальные единицы
         * искл-или - заменит единицу, не изменив остальные значения (то, что надо)
         */
        else{
            int indexOfBox = index/box;
            int indexInBox = index%box;
            int value = collection[indexOfBox];
            int mask = 1 << indexInBox;
            value = value ^ mask;
            collection[indexOfBox] = value;
        }
    }

    @Override
    public void setValueByIndex(int index, int value) throws IllegalArgumentException, ArrayIndexOutOfBoundsException{
        //обработка исключений
        Boolean b = (index < 0)|(index > 1023);
        if(b){
            String msg = "";
            msg = msg + "Превышены границы массива, значение (index) должно быть:\n" +
                        "- меньше 1024 ..." + "\n" +
                        "- больше нуля ..." + "\n" +
                        "метод setValueByIndex(int index, int value)" + " к полю с индексом " + index + " не применен ...";
            throw new ArrayIndexOutOfBoundsException(msg);
        }
        //логика метода
        switch (value) {
            case 0:
                try {
                    setFalseByIndex(index);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case 1:
                try {
                    setTrueByIndex(index);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
                break;
            default:
                String msg = "";
                msg = msg + "Значение должно быть либо 0 (false), либо 1 (true)\n";
                msg = msg + "Метод setValueByIndex(int index, int value) ";
                msg = msg + "для поля (index) " + index + ", для значения (value): " + value + " - не выполнен ...";
                throw new IllegalArgumentException(msg);
        }
        
    }

    @Override
    public void invertByIndex(int index) throws IndexOutOfBoundsException{
        //обработка исключений
        Boolean b = (index < 0) | (index > size);
        if (b){
            String msg = "";
            msg = msg + "Превышены границы массива, значение (index) должно быть:\n" +
                        "- меньше 1024 ..." + "\n" +
                        "- больше нуля ..." + "\n" +
                        "метод invertByIndex(int index)" + " к полю с индексом " + index + " не применен ...";
            throw new IndexOutOfBoundsException(msg);
        }
        //логика метода
        try {
            if (isContain(index)){
                setFalseByIndex(index);
            }else {
                setTrueByIndex(index);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public int countOfTrue() {
        int count = 0;
        for(int i = 0; i < size; i++){
            if (isContain(i)){
                count++;
            }
        }
        return count;
    }
    @Override
    public String toString() {
        String result = new String();
        // перебираем все поля булевого массива (0 : 1024) и выводим значения хранящиеся в этих полях
        for (int i = 0; i < size; i ++){
            result = result + isContain(i) + " : ";
        }
        return result;
    }
}
