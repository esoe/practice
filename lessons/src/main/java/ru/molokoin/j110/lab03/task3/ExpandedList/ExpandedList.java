package ru.molokoin.j110.lab03.task3.ExpandedList;

public class ExpandedList {
    private Node head = null;
    private Node tail = null;
    private class Node{
        Integer[] data = new Integer[10];
        Node next;
    }
    public static void main(String[] args) {
        System.out.println("run thread: " + Thread.currentThread().getName());
    }
    
}
