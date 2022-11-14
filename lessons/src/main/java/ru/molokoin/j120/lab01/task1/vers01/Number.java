package ru.molokoin.j120.lab01.task1.vers01;

public class Number {
    private int[] number;

    public Number(int[] number){
        setNumber(number);
    }
    public static Number ofString(String numberString){
        char[] c = numberString.toCharArray();
        int[] number = new int[c.length - 2];//убрали тире из номера (две штуки)
        if(number.length == 6){
            //
        }else{
            //
        }
        


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
