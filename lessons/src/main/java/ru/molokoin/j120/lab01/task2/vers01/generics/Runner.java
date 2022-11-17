package ru.molokoin.j120.lab01.task2.vers01.generics;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Запущен поток: " + Thread.currentThread().getName());
        //Создание списка Integer
        System.out.println("Создание списка Integer ... ");
        SimplyGenericList<Integer> listInteger = new SimplyGenericList<>(Integer.class);
        System.out.println(listInteger.clazz);

        //добавление элементов в список
        System.out.println("Добавление данных в список ... ");
        listInteger.addFirst(23);
        listInteger.addLast(47);
        listInteger.addFirst(21);
        listInteger.addLast(50);
        listInteger.addFirst(18);
        listInteger.addLast(53);
        listInteger.addFirst(12);
        listInteger.addLast(64);

        //вывод в консоль всех элементов списка
        System.out.println("Вывод в консоль всех элементов списка ... ");
        listInteger.printAll();

        //Вывод в консоль результатов обработки списка
        System.out.println("Вывод в консоль результатов обработки списка ...");
        
        //печатаем первый и последний элементы списка
        System.out.print("head ");
        listInteger.printNode(listInteger.getHead());
        System.out.print("tail ");
        listInteger.printNode(listInteger.getTail());

        //удаление первого элемента списка
        System.out.println("Удаление первого элемента списка: " + listInteger.executeHead());
        System.out.println("Итоговый список ... " );
        listInteger.printAll();

        //удаление последнего элемента списка
        System.out.println("Удаление последнего элемента списка: " + listInteger.executeTail());
        System.out.println("Итоговый список ... " );
        listInteger.printAll();
        //
        int i = 47;
        System.out.println("Удаление из списка полей со значением: " + i );
        listInteger.deleteNodeByValue(i);
        System.out.println("Итоговый список ... " );
        listInteger.printAll();

        //действия над всеми элементами списка
        System.out.println("действия над всеми элементами списка ... " + UseMath.INCREASE );
        listInteger.math(UseMath.INCREASE, 20);
        System.out.println("Итоговый список ... " );
        listInteger.printAll();
        System.out.println("for each : sout");
        for (Integer in : listInteger) {
            System.out.println(in);
        }
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");
        //Создание списка String
        System.out.println("Создание списка String ... ");
        SimplyGenericList<String> listString = new SimplyGenericList<>(String.class);
        System.out.println(listString.clazz);

        //добавление элементов в список
        System.out.println("Добавление данных в список ... ");
        listString.addFirst("23");
        listString.addLast("47");
        listString.addFirst("21");
        listString.addLast("50");
        listString.addFirst("18");
        listString.addLast("53");
        listString.addFirst("12");
        listString.addLast("64");

        //вывод в консоль всех элементов списка
        System.out.println("Вывод в консоль всех элементов списка ... ");
        listString.printAll();

        //Вывод в консоль результатов обработки списка
        System.out.println("Вывод в консоль результатов обработки списка ...");
        
        //печатаем первый и последний элементы списка
        System.out.print("head ");
        listString.printNode(listString.getHead());
        System.out.print("tail ");
        listString.printNode(listString.getTail());

        //удаление первого элемента списка
        System.out.println("Удаление первого элемента списка: " + listString.executeHead());
        System.out.println("Итоговый список ... " );
        listString.printAll();

        //удаление последнего элемента списка
        System.out.println("Удаление последнего элемента списка: " + listString.executeTail());
        System.out.println("Итоговый список ... " );
        listString.printAll();
        //
        String s = "47";
        System.out.println("Удаление из списка полей со значением: " + s );
        listString.deleteNodeByValue(s);
        System.out.println("Итоговый список ... " );
        listString.printAll();

        //действия над всеми элементами списка
        System.out.println("действия над всеми элементами списка ... " + UseMath.INCREASE );
        listString.math(UseMath.INCREASE, "20");
        System.out.println("Итоговый список ... " );
        listString.printAll();
        System.out.println("for each : sout");
        for (String st : listString) {
            System.out.println(st);
        }


    }
}
