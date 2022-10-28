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
            Node tmp = new Node();
            tmp.data = data;
            tmp.next = head;
            head = tmp;
        }
    }
    /**
     * Добавление нового элемента в конец списка
     */
    public void addLast(Integer data){
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
    public Integer executeFirst(){
        Integer tmp = null;
        tmp = head.data;
        head = head.next;
        return tmp;
    }
    /**
     * Преобразование массива в односвязный список
     * @param array
     * @return
     * TODO в перспективе сделать преобразование массива
     * */
    public SimplyList arrayToList(Integer[] array){
        SimplyList sl = new SimplyList();
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

    /**
     * Класс, объекты которого являются элементами списка (узлы / ноды / node) в которых хранятся основные данные и ссылка на следующий элемент списка. 
     */
    private class Node{
        Integer data;
        Node next;
    }
    public static void main(String[] args) {
        System.out.println("Запущен поток: " + Thread.currentThread().getName());
        //Создание списка
        System.out.println("Создание списка ... ");
        SimplyList list = new SimplyList();

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
        list.printNode(list.head);
        System.out.print("tail ");
        list.printNode(list.tail);


    }
}
