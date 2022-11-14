package ru.molokoin.j120.lab01.task1.vers01;

public class Number {
    private int[] number;

    public Number(int[] number){
        setNumber(number);
    }
    public static Number ofString(String numberString){
        
        return null;
    }

    /**
     * @param number the number to set
     */
    public void setNumber(int[] number) {
        this.number = number;
    }
    /**
     * @return the number
     */
    public int[] getNumber() {
        return number;
    }


    
}
