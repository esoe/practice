package ru.molokoin.SimplyList;

/**
 * Класс содержащий инструменты управления списком и данными в нем
 */
public class SimplyList {
    private Node head;
    private Node tail;
    /**
     * Добавление элемента в начало списка
     * @param data
     */
    public void addFirst(Integer data){
        if(head == null){
            head = new Node();
            head.data = data;
            tail = head;
        }else{
            Node temp = new Node();
            temp.data = data;
            temp.next = head;
            head = temp;
        }
        
    }
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



    /**
     * Класс, объекты которого являются элементами списка (узлы / ноды / node) в которых хранятся основные данные и ссылка на следующий элемент списка. 
     */
    private class Node{
        Integer data;
        Node next;
    }
    public static void main(String[] args) {
        System.out.println("Запущен поток: " + Thread.currentThread().getName());
        SimplyList list = new SimplyList();
        //list.addFirst(23);
        //вывод в консоль всех элементов списка
        list.printAll();

        //печатаем первый и последний элементы списка
        System.out.print("head ");
        list.printNode(list.head);
        System.out.print("tail ");
        list.printNode(list.tail);


    }
}
