package ru.molokoin.j120.lab01.task2.vers01.generics;

import java.util.Iterator;

/**
 * Класс содержащий инструменты управления списком и данными в нем
 * @param <T>
 */
public class SimplyGenericList<T> implements Iterable<T> {
    /**
     * Поле элемента списка, хранит данные о первом элементе
     */
    private Node<T> head;
    /**
     * Поле элемента списка, хранит данные о последнем элементе
     */
    private Node<T> tail;
    /**
     * остаток не доделаной конфигурации,<p>
     * Хранит данные о передаваемом в список типе данных,<p>
     * предполагалось с помощью него реализовывать применение различных реализаций методов,<p>
     * в завиимости от типов передаваемых пользователем даных.
     */
    Class<?> clazz;//для определения класса, с которым пользователь использует список

    /**
     * Конструктор списка, принимающий в качестве параметра тип данных, передаваемых пользователем в список.
     * @param clazz
     */
    public SimplyGenericList(Class<?> clazz){
        this.clazz = clazz;
    }
    /**
     * @return the head
     */
    public Node<T> getHead() {
        return head;
    }
    /**
     * @param head the head to set
     */
    public void setHead(Node<T> head) {
        this.head = head;
    }
    /**
     * @return the tail
     */
    public Node<T> getTail() {
        return tail;
    }
    /**
     * @param tail the tail to set
     */
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
    /**
     * Добавление элемента в начало списка
     * @param data
     */
    public void addFirst(T data){
        if(head == null){
            head = new Node<T>();
            head.data = (T)data;
            tail = head;
        }else{
            Node<T> tmp = new Node<T>();
            tmp.data = (T)data;
            tmp.next = head;
            head = tmp;
        }
    }
    /**
     * Добавление нового элемента в конец списка
     */
    public void addLast(T data){
        if(head == null){
            addFirst((T)data);
        }else{
            Node<T> tmp = new Node<T>();
            tmp.data = (T)data;
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
        tmp = (T)head.data;
        head = head.next;
        return tmp;
    }
    /**
     * Удаление последнего элемента списка
     * @return
     */
    public T executeTail(){
        T tmp = (T)tail.data;//готовы писать данные удаляемого элемента
        Node<T> bufNode = head;
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
        Node<T> temp = head;
        while (temp != null){
            printNode(temp);
            temp = temp.next;
        }
    }
    /**
     * Вывод в консоль данных указанной ноды
     * @param node
     */
    public void printNode(Node<T> node){
        if (node == null){
            System.out.println(">>> " + null);

        }else{
            System.out.println(">>> " + (T)node.data);
        }
    }
    public void deleteNodeByValue(T value){
        //обработка случая, когда первый элемент списка подлежит удалению
        while (head.data == (T)value){
            head = head.next;
        }
        //первый элемент списка точно не подлежит удалению
        Node<T> buf = new Node<T>();
        buf = head;
        while(buf.next != null){
            if (buf.next.data != (T)value){
                buf = buf.next;
            }else{
                buf.next = buf.next.next;
            }
        }
    }
    /**
     * не понятно почему не работает,
     * оператор "+" не предусмотрен для объектов класса Т
     * как предусмотреть ???
     * можно попробовать сделать еще один свитч по типу данных, передаваемых пользователем в список,
     * но поля в списке всеравно окажутся <T> и к ним не понятно как получать доступ.
     * с агрегированием аналогичная ситуация
     * @param use
     * @param value
     */

    public void math(UseMath use, T value){
        // try{
        //     switch (use){
        //         case INCREASE : {
        //             Node buf = head;
        //             buf.data = buf.data + value;
        //             System.out.println("buf.data " + buf.data);
        //             while (buf.next != null){
        //                 buf.next.data = (T)buf.next.data + (T)value;
        //                 System.out.println("buf.data " + buf.next.data);
        //                 buf = buf.next;
        //             }
        //             break;
        //         }
        //         case DECREASE : {
        //         }
        //     }
        // }catch(Exception e){
        //     System.out.println(e.getMessage());
        // }
    }
    /**
     * Метод интерфейса Iterable, рализует функционирование итератора,
     * возможность перебора списка циклом foreach
     */
    @Override
    public Iterator<T> iterator(){
        return new SimplyGenericListIterator<T>(head);
    }
    public int size() {
        int index = 1;
        Node<T> current = head;
        while (current.next != null){
            current = current.next;
            index++;
        }
        return index;
    }

    /**
     * Класс, объекты которого являются элементами списка (узлы / ноды / node) в которых хранятся основные данные и ссылка на следующий элемент списка. 
     * не понятно, почему создаются объекты, если класс статический ...
     */
    public static class Node<T>{
        T data;
        Node next;
    }

    /**
     * Класс, устанавливающий методы рализации интерфейса Iterator,
     * устанавливает методы, испльзуемые при реализации метода iterator() интерфейса Iterable
     * !! скопировал рализацию с практики, на много проще моей получилась .. 
     */
    public static class SimplyGenericListIterator<T> implements Iterator<T> {
        Node nextNode;

        /**
         * Конструктор итератора, передаем в него головную ноду.
         * @param nextNode
         */
        public SimplyGenericListIterator(Node nextNode) {
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

}
