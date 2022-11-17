package ru.molokoin.j120.lab01.task2.vers01.generics;

import java.util.Iterator;

/**
 * Класс содержащий инструменты управления списком и данными в нем
 * @param <T>
 */
public class SimplyGenericList<T> implements Iterable<T> {
    private Node head;
    private Node tail;
    Class<?> clazz;//для определения класса, с которым пользователь использует список

    public SimplyGenericList(Class<?> clazz){
        this.clazz = clazz;
    }
    /**
     * @return the head
     */
    public Node getHead() {
        return head;
    }
    /**
     * @param head the head to set
     */
    public void setHead(Node head) {
        this.head = head;
    }
    /**
     * @return the tail
     */
    public Node getTail() {
        return tail;
    }
    /**
     * @param tail the tail to set
     */
    public void setTail(Node tail) {
        this.tail = tail;
    }
    /**
     * Добавление элемента в начало списка
     * @param data
     */
    public void addFirst(T data){
        if(head == null){
            head = new Node();
            head.data = data;
            tail = head;
        }else{
            Node tmp = new Node();
            tmp.data = data;
            tmp.next = head;
            head = tmp;
        }
    }
    /**
     * Добавление нового элемента в конец списка
     */
    public void addLast(T data){
        if(head == null){
            addFirst(data);
        }else{
            Node tmp = new Node();
            tmp.data = data;
            tail.next = tmp;
            tail = tmp;
        }
    }
    /**
     * удаляет первый элемент списка и возвращает его данные
     * @return
     * TODO вдруг список пустой
     * TODO вдруг список содержит только один элемент
     */
    public T executeHead(){
        T tmp = null;
        tmp = head.data;
        head = head.next;
        return tmp;
    }
    /**
     * Удаление последнего элемента списка
     * @return
     */
    public T executeTail(){
        T tmp = tail.data;//готовы писать данные удаляемого элемента
        Node bufNode = head;
        //у предпоследнего элемента удаляем ссылку на tail
        while (bufNode.next != tail){
            bufNode = bufNode.next;
        }
        bufNode.next = null;
        return tmp;
    }
    /**
     * Преобразование массива в односвязный список
     * @param array
     * @return
     * TODO в перспективе сделать преобразование массива
     * */
    public SimplyGenericList<T> arrayToList(T[] array){
        SimplyGenericList<T> sl = new SimplyGenericList<T>(clazz);
        return sl;
    }
    /**
     * вывод в консоль всех элементов списка, по порядку
     */
    public void printAll(){
        Node temp = head;
        while (temp != null){
            printNode(temp);
            temp = temp.next;
        }
    }
    /**
     * Вывод в консоль данных указанной ноды
     * @param node
     */
    public void printNode(Node node){
        if (node == null){
            System.out.println(">>> " + null);

        }else{
            System.out.println(">>> " + node.data);
        }
    }
    public void deleteNodeByValue(T value){
        //обработка случая, когда первый элемент списка подлежит удалению
        while (head.data == value){
            head = head.next;
        }
        //первый элемент списка точно не подлежит удалению
        Node buf = new Node();
        buf = head;
        while(buf.next != null){
            if (buf.next.data != value){
                buf = buf.next;
            }else{
                buf.next = buf.next.next;
            }
        }
    }
    // public void math(UseMath use, T value){
    //     switch (use){
    //         case INCREASE : {
    //             Node buf = head;
    //             buf.data = buf.data + value;
    //             System.out.println("buf.data" + buf.data);
    //             while (buf.next != null){
    //                 buf.next.data = buf.next.data + value;
    //                 System.out.println("buf.data" + buf.next.data);
    //                 buf = buf.next;
    //             }
    //             break;
    //         }
    //         case DECREASE : {
    //         }
    //     }
    // }
    @Override
    public Iterator<T> iterator(){
        return new SimplyGenericListIterator<T>(this);

    }
    public int size() {
        int index = 1;
        Node current = head;
        while (current.next != null){
            current = current.next;
            index++;
        }
        return index;
    }

    /**
     * Класс, объекты которого являются элементами списка (узлы / ноды / node) в которых хранятся основные данные и ссылка на следующий элемент списка. 
     */
    public class Node{
        T data;
        Node next;
    }

    
}
