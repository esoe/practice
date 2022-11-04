package ru.molokoin.logic;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Запущен основной поток: " + Thread.currentThread().getName() + " ...");
        System.out.println("Создаем новую коллекцию ...");
        BooleanCollection bc = new BooleanCollection();
        System.out.println("Выводим коллекцию в консоль ...");
        System.out.println();
        System.out.println(bc.toString());
    }
}
