package ru.molokoin.j120.lab01.task1.vers03;

import java.util.Arrays;

public class Code implements IPart{
    private int[] value;
    public Code(String string){
        setValue(IPart.ofString(string));
    }

    @Override
    public int[] getValue() {
        return value;
    }

    @Override
    public void setValue(int[] value) {
        this.value = value;
    }

    /**
     * Метод преобразует int[] в строку
     */
    @Override
    public String toString(){
        String s = "(";
        String string = "";
        string = Arrays.toString(value).replaceAll(Regex.NON_DIGIT.get(), "");
        s = s + string + ")";
        return s;
    }

    @Override
    public void print() {
        System.out.println(toString());
    }
    public static void main(String[] args) {
        Code code = new Code("(812)");
        code.print();
    }
    
}
