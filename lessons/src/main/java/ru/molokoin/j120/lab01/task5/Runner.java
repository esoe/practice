package ru.molokoin.j120.lab01.task5;

import java.util.ArrayList;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println("Доработка списка DoublyGenericList");
        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");

        //исходные данные в массиве
        Integer[] array = {9, 12, 24,38, 43, 51, 62, 79, 81, 99};
        //создали новый список
        DoublyGenericList<Integer> listInteger = new DoublyGenericList<Integer>();
        //занесли данные массива в список
        listInteger.arrayToHead(array);
        //вывели данные списка в консоль
        for (Integer integer : listInteger) {
            
        }



    }
}
