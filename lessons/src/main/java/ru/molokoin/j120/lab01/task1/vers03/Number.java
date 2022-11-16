package ru.molokoin.j120.lab01.task1.vers03;

import java.util.Arrays;

public class Number implements IPart{
    int[] value;

    Number(String stringValue){
        setValue(IPart.ofString(stringValue));
    }

    @Override
    public int[] getValue() {
        return this.value;
    }

    @Override
    public void setValue(int[] value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.println(toString());
    }

    /**
     * Преобразование int[] в строку<p>
     * с добавлением "-" перед последними двумя парами цифр<p>
     * Пример: 000-00-00
     */
    @Override
    public String toString(){
        String string = Arrays.toString(value).replaceAll(Regex.NON_DIGIT.get(), "");//получили строку цифр, без дефисов
        int length = string.length();
        String first = string.substring(0, length-4);
        String second = string.substring(length-4, length-2);
        String therd = string.substring(length-2, length);
        String result = first + "-" + second + "-" + therd;
        return result;
    }
    public static void main(String[] args) {
        Number number = new Number("123-34-45");
        System.out.println(number.toString());
        number.print();
    }
}
