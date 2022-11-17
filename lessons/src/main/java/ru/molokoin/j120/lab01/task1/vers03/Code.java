package ru.molokoin.j120.lab01.task1.vers03;

import java.util.Arrays;

/**
 * Класс хранит данные о коде региона, составляющем первую секцию полного номера тлефона,<p>
 * и предоставляет методы, для обработки данных о коде региона.<p>
 * Класс реализует интерфейс IPart, прдусматривающий основные методы,<p>
 * для работы с секциями полного номера телефона
 */
public class Code implements IPart{
    private int[] value;
    /**
     * Основной конструктор класса,<p>
     * создающий объекты класса на основании строкового представления кода региона
     * @param string
     */
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
     * Метод преобразует поле int[] value в строку
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
