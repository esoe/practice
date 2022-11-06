package ru.molokoin.logic;

public class BooleanCollection implements CollectionFace{
    public Boolean[] collection = new Boolean[size];
    BooleanCollection(){
        for(int i = 0; i < size; i++){
            collection[i] = false;
        }
        
    }
    /**
     * возвращает значение хранящееся в поле булевого массива с порядковым номером index
     */
    @Override
    public boolean isContain(int index) {
        Boolean result = collection[index];
        return result;
    }

    @Override
    public void setTrueByIndex(int index)throws ArrayIndexOutOfBoundsException{
        if (index > 1023 ){
            throw new ArrayIndexOutOfBoundsException("Превышены границы массива, значение должно быть меньше 1024 ..." + "\n" + "метод setTrueByIndex(int index)" + " к полю с индексом " + index + " не применен ...");
        }else{
            if (index < 0){
                throw new ArrayIndexOutOfBoundsException("Превышены границы массива, значение должно быть, больше или равно 0 ...");
            }
        }
        collection[index] = true;
    }

    @Override
    public void setFalseByIndex(int index) throws ArrayIndexOutOfBoundsException{
        if (index > 1023 ){
            throw new ArrayIndexOutOfBoundsException("Превышены границы массива, значение должно быть меньше 1024 ..." + "\n" + "метод setFalseByIndex(int index)" + " к полю с индексом " + index + " не применен ...");
        }else{
            if (index < 0){
                throw new ArrayIndexOutOfBoundsException("Превышены границы массива, значение должно быть, больше или равно 0 ...");
            }
        }
        collection[index] = false;
        
    }

    /**
     * value 0 => false
     * value 1 => true
     * в остальных вариантах вылетает исключение.
     * так же ошибка будет, если index не попадает в границы массива
     */
    @Override
    public void setValueByIndex(int index, int value) throws IllegalArgumentException{
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
    public void invertByIndex(int index) throws ArrayIndexOutOfBoundsException {
        Boolean bool = (index < 0) || (index >= size);
        if (bool){
            String msg = "";
            msg = msg + "Превышены границы массива, значение (index) должно быть:\n" +
                        "- меньше 1024 ..." + "\n" +
                        "- больше нуля ..." + "\n" +
                        "метод invertByIndex(int index)" + " к полю с индексом " + index + " не применен ...";
            throw new ArrayIndexOutOfBoundsException(msg);
        }else{
            /**
             * проверять collection[index] на null не нужно,
             * все значения инициированы в конструкторе класса
             */
            if (collection[index] == true){
                collection[index] = false;
            }else{
                collection[index] = true;
            }
        }
        
    }

    @Override
    public int countOfTrue() {
        int i = 0;
        for(Boolean b : collection){
            if(b == true){
                i++;
            }
        }
        return i;
    }

    @Override
    public String toString() {
        String result = new String();
        // перебираем все поля булевого массива (0 : 1023) и выводим значения хранящиеся в этих полях
        for (int i = 0; i < size; i ++){
            result = result + isContain(i) + " : ";
        }
        return result;
    }
    
}
