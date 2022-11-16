package ru.molokoin.j120.lab01.task1.vers03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Code implements IPart{
    int[] value;

    @Override
    public int[] getValue() {
        return value;
    }

    @Override
    public void setValue(int[] value) {
        this.value = value;
    }

    @Override
    public int[] ofString(String string) {
        String regex = "\\d";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        //удалили первый и последний элементы строки ..
        string = string.substring(1, string.length()-1);


        //int[] result= new int[string.length()-2];
        
        return result;
    }

    @Override
    public String toString(){
        String s = "";
        String value = "";
        for (int i : this.value) {
            value += i;
        }
        s = s + "(" + value + ")";
        return s;
    }

    @Override
    public void print() {
        // TODO Auto-generated method stub
        
    }
    
}
