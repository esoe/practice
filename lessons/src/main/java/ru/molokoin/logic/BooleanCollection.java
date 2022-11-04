package ru.molokoin.logic;

public class BooleanCollection implements CollectionFace{
    Boolean[] collection = new Boolean[size];


    @Override
    public boolean isContain(int index) {
        return collection[index];
    }

    @Override
    public void setTrueByIndex(int index) {
        collection[index] = true;
        
    }

    @Override
    public void setFalseByIndex(int index) {
        collection[index] = false;
        
    }

    /**
     * value 0 => true, else 0
     */
    @Override
    public void setValueByIndex(int index, int value) {
        if (value == 0){
            collection[index] = false;
        }else{
            collection[index] = true;
        }
    }

    @Override
    public void invertByIndex(int index) {
        if (collection[index] == true){
            collection[index] = false;
        }else{
            collection[index] = true;
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
        String s = new String();
        for(Boolean b : collection){
            s = s + b + ", ";
        }
        return s;
    }
    
}
