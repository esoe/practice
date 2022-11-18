package ru.molokoin.j120.lab01.task2.vers01.samples;

import java.util.Iterator;

public class MainClass {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(15);
        list.add(23);
        list.add(45);
        list.add(432);
        list.add(67);
        list.add(87);
        list.add(124);
        System.out.println("Last item = " + list.getTail());
        System.out.println("Index item = " + list.get(7));
        System.out.println("List size = " + list.size());
        
        System.out.println("Вывод с помощью метода forEach");
        list.forEach(e -> System.out.print(e + ", "));
        Iterator<Integer> iter = list.iterator();
        System.out.println();
        
        System.out.println("Вывод с помощью итератора");
        
        while(iter.hasNext()){
            System.out.print(iter.next() + ", ");
        }
        System.out.println();
        
        System.out.println("Вывод с помощью цикла forEach");
        for(Integer num : list){
            System.out.print(num + ", ");
        }
    }
}
