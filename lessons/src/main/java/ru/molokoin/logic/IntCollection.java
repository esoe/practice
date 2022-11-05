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
     */
    @Override
    public boolean isContain(int index) {
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

    @Override
    public void setTrueByIndex(int index) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setFalseByIndex(int index) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setValueByIndex(int index, int value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void invertByIndex(int index) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int countOfTrue() {
        // TODO Auto-generated method stub
        return 0;
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
