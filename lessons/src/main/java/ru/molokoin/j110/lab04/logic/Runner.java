package ru.molokoin.j110.lab04.logic;

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
            try {
                int i = 5;
                bc.invertByIndex(i);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("проверка invertByIndex(int index) с предельными значениями аргументов ...");
            try {
                int i = 1024;
                bc.invertByIndex(i);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("--------------------------------------------");
        }

        //проверка метода countOfTrue()
        {
            String msg = "Количество полей в массиве, со значением true: " + bc.countOfTrue();
            System.out.println(msg);
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

        //проверка метода isContain(int index)
        {
            //вывод коллекции в консоль по сути является проверкой метода
        }

        //проверка метода setTrueByIndex(int index)
        {
            System.out.println("Проверка метода setTrueByIndex(int index) ...");
            int i = 1;
            ic.setTrueByIndex(i);
            ic.setTrueByIndex(0);
            ic.setTrueByIndex(2);
            System.out.println("--------------------------------------------");

        }

        //проверка метода setFalseByIndex(int index)
        {
            System.out.println("Проверка метода setFalseByIndex(int index) ...");
            int i = 1;
            ic.setFalseByIndex(i);
            System.out.println("--------------------------------------------");
        }

        //проверка метода setValueByIndex(int index, int value)
        {
            System.out.println("Проверка метода setValueByIndex(int index, int value) ...");
            int index = 3;
            int value = 1;
            try {
                ic.setValueByIndex(index, value);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            //проверка с предельными значениями
            System.out.println("Проверка метода setValueByIndex(int index, int value) с предельными значениями ...");
            System.out.println("превышение по value ...");
            try {
                ic.setValueByIndex(index, 5);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("превышение по index ...");
            try {
                ic.setValueByIndex(5000, value);
            } catch ( ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("--------------------------------------------");
        }

        //проверка метода invertByIndex(int index)
        {
            System.out.println("Проверка метода invertByIndex(int index) ...");
            int i = 5;
            try {
                ic.invertByIndex(i);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Проверка метода invertByIndex(int index). Проверка предельных значений...");
            i = 2000;
            try {
                ic.invertByIndex(i);
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("--------------------------------------------");
        }
        
        //проверка метода countOfTrue()
        System.out.println("Количество полей со значением true: " + ic.countOfTrue());

        //выводим коллекцию в консоль
        {
            System.out.println("Выводим коллекцию в консоль ...");
            System.out.println();
            System.out.println(ic.toString());
        }
    }
}
