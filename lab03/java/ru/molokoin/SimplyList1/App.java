package ru.molokoin.SimplyList1;
public class App {
    public static void main(String[] args) {
        System.out.println("Запущен поток: " + Thread.currentThread().getName());
        //данные
        //int[] i = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String i[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        
        //Хранилище
        Pearl treasury = new Pearl();

        //добавляем элементы в конец/последовательно
        treasury.addLast(i[0]);
        treasury.addLast(i[1]);
        // treasury.addLast(i[2]);
        // treasury.addLast(i[3]);
        // treasury.addLast(i[4]);
        // treasury.addLast(i[5]);
        // treasury.addLast(i[6]);
        // treasury.addLast(i[7]);
        // treasury.addLast(i[8]);
        // treasury.addLast(i[9]);

        //добавляем элементы в начало списка
        // treasury.addFirst(i[0]);
        // treasury.addFirst(i[1]);
        // treasury.addFirst(i[2]);
        // treasury.addFirst(i[3]);
        // treasury.addFirst(i[4]);
        // treasury.addFirst(i[5]);
        // treasury.addFirst(i[6]);
        // treasury.addFirst(i[7]);
        // treasury.addFirst(i[8]);
        // treasury.addFirst(i[9]);
        
        //печать из хранилища
        treasury.print();
        //печать последнего элемента
        System.out.print("Последний элемент списка (get): ");
        treasury.getLast().print();

        System.out.print("Последний элемент списка (execute): ");
        treasury.executeLast().print();

        //печать из хранилища
        System.out.print("Оставшиеся в списке данные: ");
        treasury.print();
    }
}
