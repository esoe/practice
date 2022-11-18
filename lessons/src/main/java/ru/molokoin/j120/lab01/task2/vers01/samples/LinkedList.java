package ru.molokoin.j120.lab01.task2.vers01.samples;

import java.util.Iterator;

public class LinkedList <T> implements Iterable<T>{
    private Node head;
    private Node tail;
    
    public LinkedList(){}

    //Добавление элемента в конец списка
    public void add(T item){
        if(head==null){
            head = new Node();
            tail = head;
            head.data = item;
        }
        else {
            Node tempNode = new Node();
            tempNode.data = item;
            tempNode.previous = tail;
            tail.next = tempNode;
            tail = tempNode;
        }
    }

    //Получение значения элемента по его индексу
    public T get(int index){
        if(index<0) throw new IllegalArgumentException();
        int tempIndex = 0;
        Node tempNode = head;
        while(tempNode!=null){
            if(tempIndex==index) return (T)tempNode.data;
            tempNode = tempNode.next;
            tempIndex++;
        }
        throw new IndexOutOfBoundsException();
    }

    //Получение размера списка
    public int size(){
        int size = 0;
        Node tempNode = head;
        while (tempNode!=null){
            size++;
            tempNode = tempNode.next;
        }
        return size;
    }

    //Получение первого элемента
    public T getHead(){
        if(head==null) return null;
        return (T)head.data;
    }

    //Получение последнего элемента
    public T getTail(){
        if(tail==null) return null;
        return (T)tail.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<>(head);
    }
    
    private static class LinkedIterator <T> implements Iterator<T>{
        Node nextNode;

        public LinkedIterator(Node nextNode) {
            this.nextNode = nextNode;
        }
        

        @Override
        public boolean hasNext() {
            if(nextNode!=null) return true;
            return false;
        }

        @Override
        public T next() {
            T value = (T)nextNode.data;
            nextNode = nextNode.next;
            return value;
        }
        
    }

    //Внутренний класс, хранящий полезное значение и ссылки на следующий узел и предыдущий
    private static class Node <T> {
        T data;
        Node next;
        Node previous;
    }
}
