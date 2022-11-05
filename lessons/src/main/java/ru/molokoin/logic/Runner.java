package ru.molokoin.logic;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Запущен основной поток: " + Thread.currentThread().getName() + " ...");
        System.out.println("=====Работа с булевым массивом=====");
        System.out.println("Создаем новую коллекцию ...");
        BooleanCollection bc = new BooleanCollection();

        //проверка метода setTrueByIndex(int index)
        {
            System.out.println("Проверка метода setTrueByIndex(int index) ...");
            int index = 3;
            System.out.println("index = " + index);
            try {
                bc.setTrueByIndex(index);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
            //проверка метода setTrueByIndex(int index) с предельными значениями
            System.out.println("Проверка метода setTrueByIndex(int index) с предельными значениями (выше верхней границы) ...");
            index = -5;
            System.out.println("index = " + index);
            try {
                bc.setTrueByIndex(index);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
            System.out.println("проверка метода setTrueByIndex(int index) с предельными значениями (меньше нижней границы) ...");
            index = 1024;
            System.out.println("index = " + index);
            try {
                bc.setTrueByIndex(index);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("--------------------------------------------");
        }
        
        //проверка setValueByIndex(int index, int value)
        {
            System.out.println("проверка setValueByIndex(int index, int value) ...");
            int index = 1;
            int value = 1;
            try {
                bc.setValueByIndex(index, value);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("проверка setValueByIndex(int index, int value) с предельными значениями ...");
            index = 1024;
            value = 1;
            try {
                bc.setValueByIndex(index, value);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("проверка setValueByIndex(int index, int value) с предельными значениями ...");
            index = 0;
            value = 10;
            try {
                bc.setValueByIndex(index, value);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("--------------------------------------------");
        }
        
        //проверка invertByIndex(int index)
        {
            System.out.println("проверка invertByIndex(int index) ...");
            System.out.println("--------------------------------------------");
        }

        //вывод коллекции в консоль
        {
            System.out.println("Выводим коллекцию в консоль ...");
            System.out.println();
            System.out.println(bc.toString());
            System.out.println();
        }
        
        System.out.println("=====Работа с целочисленным массивом=====");
        System.out.println("Создаем новую коллекцию ...");
        IntCollection ic = new IntCollection();
        System.out.println("Выводим коллекцию в консоль ...");
        System.out.println();
        System.out.println(ic.toString());
    }
}
