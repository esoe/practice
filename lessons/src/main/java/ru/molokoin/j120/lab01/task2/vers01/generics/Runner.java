package ru.molokoin.j120.lab01.task2.vers01.generics;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Запущен поток: " + Thread.currentThread().getName());
        //Создание списка
        System.out.println("Создание списка ... ");
        SimplyGenericList<Integer> list = new SimplyGenericList<>(Integer.class);
        System.out.println(list.clazz);

        //добавление элементов в список
        System.out.println("Добавление данных в список ... ");
        list.addFirst(23);
        list.addLast(47);
        list.addFirst(21);
        list.addLast(50);
        list.addFirst(18);
        list.addLast(53);
        list.addFirst(12);
        list.addLast(64);

        //вывод в консоль всех элементов списка
        System.out.println("Вывод в консоль всех элементов списка ... ");
        list.printAll();

        //Вывод в консоль результатов обработки списка
        System.out.println("Вывод в консоль результатов обработки списка ...");
        
        //печатаем первый и последний элементы списка
        System.out.print("head ");
        list.printNode(list.getHead());
        System.out.print("tail ");
        list.printNode(list.getTail());

        //удаление первого элемента списка
        System.out.println("Удаление первого элемента списка: " + list.executeHead());
        System.out.println("Итоговый список ... " );
        list.printAll();

        //удаление последнего элемента списка
        System.out.println("Удаление последнего элемента списка: " + list.executeTail());
        System.out.println("Итоговый список ... " );
        list.printAll();
        //
        int i = 47;
        System.out.println("Удаление из списка полей со значением: " + i );
        list.deleteNodeByValue(i);
        System.out.println("Итоговый список ... " );
        list.printAll();

        // //действия над всеми элементами списка
        // System.out.println("действия над всеми элементами списка ... " + UseMath.INCREASE );
        // list.math(UseMath.INCREASE, 20);
        // System.out.println("Итоговый список ... " );
        // list.printAll();
        System.out.println("for each : sout");
        for (Integer in : list) {
            System.out.println(in);
        }

    }
}
