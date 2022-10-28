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
    public Integer executeHead(){
        Integer tmp = null;
        tmp = head.data;
        head = head.next;
        return tmp;
    }
    /**
     * Удаление последнего элемента списка
     * @return
     */
    public Integer executeTail(){
        Integer tmp = tail.data;//готовы писать данные удаляемого элемента
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
    public void deleteNodeByValue(Integer value){
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
    public void math(UseMath use, Integer value){
        switch (use){
            case INCREASE : {
                Node buf = new Node();
                buf = head;
                buf.data = buf.data + value;
                System.out.println("buf.data" + buf.data);
                while (buf.next != null){
                    buf.next.data = buf.next.data + value;
                    System.out.println("buf.data" + buf.next.data);
                    buf = buf.next;
                }
                break;
            }
            case DECREASE : {

            }
            
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

        //действия над всеми элементами списка
        System.out.println("действия над всеми элементами списка ... " + UseMath.INCREASE );
        list.math(UseMath.INCREASE, 20);
        System.out.println("Итоговый список ... " );
        list.printAll();

    }
}
