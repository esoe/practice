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
            System.out.println("integer : " + integer);
        }
        //выводим данные списка в обратном порядке
        for (Integer integer : listInteger.reverce()) {
            System.out.println("integer.reverce() : " + integer);
        }
        //клонируем список
        System.out.println("клонируем список ...");
        DoublyGenericList<Integer> listIntegerClone = listInteger.clone(listInteger);
        listIntegerClone.addLast(700);
        listIntegerClone.addLast(800);
        listIntegerClone.addLast(900);
        System.out.println("Добавили новые данные в клона ...");
        System.out.println("listInteger:");
        listInteger.printForvard();
        System.out.println();
        System.out.println("listIntegerClone:");
        listIntegerClone.printForvard();

        /**
         * выполняем заданное действие с каждым элементом списка
         * (добавим 500)
         */
        System.out.println("Добавляем по 500 к каждому элементу списка ...");
        listInteger.increase(500);
        System.out.println("listInteger + 500:");
        listInteger.printForvard();
        System.out.println("listIntegerClone:");
        listIntegerClone.printForvard();
        System.out.println("Изменение основного списка не отразилось на клоне!!!");

        /**
         * добавим данных к строковым значениям
         */
        //исходные данные в массиве
        String[] arr = {"one", "two", "three", "four", "five"};
        //создали новый список
        DoublyGenericList<String> listString = new DoublyGenericList<String>();
        //занесли данные массива в список
        listString.arrayToHead(arr);
        //добавили smth в обратной последовательности
        listString.increase(" + smth");
        System.out.println("listString.reverce().increase(smth);");
        listString.printForvard();

        

         /**
          * агрегирование (суммируем элементы списка)
          */

    }
}
