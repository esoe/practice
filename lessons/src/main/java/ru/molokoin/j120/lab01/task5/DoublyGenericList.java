package ru.molokoin.j120.lab01.task5;

import java.util.ArrayList;
import java.util.Iterator;

public class DoublyGenericList <T> implements Iterable<T>, Cloneable{
    private Node<T> head = null;
    private Node<T> tail = null;

    /**
     * метод проверяет пустой ли список и в случае,
     * если в списке нет узла head, возвращает true.
     * Если узел head есть, но в нем отсудствую данные, также возвращается true.
     * @return true, если список пуст
     */
    public boolean isEmpty(){
        boolean isEmpty = false;
            if((getHead() != null) || (getTail() != null)){
                isEmpty = false;
            }else{
                isEmpty = true;
            }
        return isEmpty;
    }
    /**
     * добавление данных в начало списка
     * @param data
     */
    public void addFirst(T data){
        if (isEmpty()) {
            Node<T> newNode = new Node<T>();
            newNode.data = data;
            setHead(newNode);
            setTail(newNode);
        }else{
            Node<T> newNode = new Node<T>();
            newNode.data = data;
            newNode.forvard = getHead();
            getHead().backvard = newNode;
            setHead(newNode);
        }
    }
    /**
     * добавление данных в конец списка
     * @param data
     */
    public void addLast(T data){
        if (isEmpty()) {
            Node<T> newNode = new Node<T>();
            newNode.data = data;
            setHead(newNode);
            setTail(newNode);
        }else{
            Node<T> newNode = new Node<T>();
            newNode.data = data;
            newNode.backvard = getTail();
            getTail().forvard = newNode;
            setTail(newNode);
        }
    }
    /**
     * вывод в консоль всех элементов списка, по порядку
     * метод скопирован с односвязных списков
     */
    public void printForvard(){
        Node<T> tmp = getHead();
        while (tmp != null){
            printNode(tmp);
            tmp = tmp.forvard;
        }
    }
    public void printBackvard(){
        Node<T> tmp = getTail();
        while(tmp != null){
            printNode(tmp);
            tmp = tmp.backvard;
        }
    }
    /**
     * Вывод в консоль данных указанной ноды
     * Метод скопирован с односвязных списков
     * @param node
     */
    public void printNode(Node<T> node){
        if (node == null){
            System.out.println(">>> " + null);

        }else{
            System.out.println(">>> " + node.data);
        }
    }
    /**
     * извлечение данных с удалением первого элемента списка
     * TODO исключения, когда список пустой
     * @return
     */
    public T executeFirst(){
        T executed = null;
        if (isEmpty()){
            return executed;
        }
        else{
            try {
                executed = (T) getHead().data;
                setHead(getHead().forvard);
            }catch (NullPointerException e){
                System.out.println("Обнаружена исключительная ситуация: " + e);
            }
        }
        return executed;
    }
    /**
     * извлечение данных с удалением последнего элемента списка
     * @return
     */
    public T executeLast(){
        T executed = null;
        if (isEmpty()){
            return executed;
        }
        else{
            try {
                executed = (T)getTail().data;
                setTail(getTail().backvard);
                getTail().forvard = null;
            }catch (NullPointerException e){
                System.out.println("Обнаружена исключительная ситуация: " + e);
            }
        }
        return executed;
    }
    /**
     * Проверяем наличие в списке заданного в параметре метода значения
     * @param value
     * @return
     */
    public boolean isContain(T value){
        boolean isContain = false;
        if (isEmpty()){
            isContain = false;
            return isContain;
        }
        else{
            Node<T> tmp = getHead();
            while (tmp.forvard != null){
                if(tmp.data == value){
                    isContain = true;
                }
                tmp = tmp.forvard;
            }
            if (getTail().data == value){
                isContain = true;
            }
        }
        return isContain;
    }
    /**
     * удаляем ноды, содержащие данные совпадающие с указанным в методе значением
     * @param value
     */
    public void deleteByValue(T value){
        //проверяем наличие указанного значения в списке
        if (isContain(value)){
            //удаляем первые ноды, если они содержат указанное значение
            Node<T> tmp = getHead();
            while (tmp.data == value){
                executeFirst();
                tmp = getHead();
            }
            //удаляем последние ноды, если они содержат указанное значение
            tmp = getTail();
            while(tmp.data == value){
                executeLast();
                tmp = getTail();
            }
            /**
             * первая и последняя ноды точно не содержат указанное значение и не подлежат удалению
             */
            tmp = getHead();
            //
            while (tmp.forvard != null){
                //если данные текущей ноды не подлежат удалению, переходим к следующей ноде
                if (tmp.data != value){
                    tmp = tmp.forvard;
                }
                /**
                 * если текущая нода подлежит удалению
                 * (точно не первая и не последняя)
                 * 
                 */
                else{
                    tmp.forvard.backvard = tmp.backvard;
                    tmp.backvard.forvard = tmp.forvard;
                    tmp = tmp.forvard;
                }
            }
        }
    }
    /**
     * добавление элементов массива в начало списка
     * чтобы обеспечить последовательное размещение элементов массива в списке, элементы добавляются с последнего элемента массива
     * @param array
     */
    public void arrayToHead(T[]array){
        int i = array.length-1;
        while (i >= 0){
            addFirst(array[i]);
            i--;
        }
    }
    /**
     * добавление элементов массива в хвост списка
     * @param array
     */
    public void arrayToTail(T[]array){
        int i = 0;
        while (i < array.length){
            addLast(array[i]);
            i++;
        }
    }
    /**
     * добавление коллекции в начало списка
     * @param collection
     */
    public void collectionToHead(ArrayList<T> collection){
        for(int i = (collection.size()-1);i >= 0;i--) {
            addFirst(collection.get(i));
        }
    }
    /**
     * добавление коллекции в хвост списка
     * @param collection
     */
    public void collectionToTail(ArrayList<T> collection){
        for(T c : collection){
            addLast(c);
        }
    }
    public Node<T> getHead() throws NullPointerException {
        return head;
    }
    public void setHead(Node<T> head) {
        this.head = head;
    }
    public Node<T> getTail() throws NullPointerException{
        return tail;
    }
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
    
    /**
     * метод возвращает список,<p>
     * в котором элеметы расположены в обратной последовательности
     * !!! новый, а не тот же список!!!
     * надо тот-же
     * @return
     */
    public DoublyGenericList<T> reverce(){
        DoublyGenericList<T> reverce = new DoublyGenericList<>();
        for (T t : this) {
            reverce.addFirst(t);
        }
        return reverce;
    }

    /**
     * Возвращает количество звеньев в текущем списке
     * @return
     */
    private int size() {
        Node<T> next = head;
        int i = 0;
        while (next.forvard != null){
            i++;
            next = next.forvard;
        }
        return i + 1;
    }
    /**
     * метод, осуществляющий перебр элементов списка<p>
     * используется циклом foreach, или при прочих способах перебора списка
     */
    @Override
    public Iterator<T> iterator() {
        return new GenericIterator<T>(head);
    }
    /**
     * Клонируем список
     * @param source
     * @return
     */
    public DoublyGenericList<T> clone(DoublyGenericList<T> source){
        DoublyGenericList<T> target  = new DoublyGenericList<>();
        for (T t : source) {
            target.addLast(t);
        }
        return target;
    }
    /**
     * добавляем value  к каждому значению в списке
     * работает с integer или string
     * @param value
     */
    public void increase(T value){
        Node<T> buf = head;
        if (buf.data instanceof Number){
            Integer midl = buf.toInteger() + (Integer)value;
            System.out.println("(Integer)mid :" + midl);
            buf.data = (T)midl;
            while (buf.forvard != null){
                midl = buf.forvard.toInteger() + (Integer)value;
                buf.forvard.data = (T)midl;
                buf = buf.forvard;
            }
        }
        if (buf.data instanceof String){
            String midl = buf.toString() + (String)value;
            System.out.println("(String)mid :" + midl);
            buf.data = (T)midl;
            while (buf.forvard != null){
                midl = buf.forvard.toString() + (String)value;
                buf.forvard.data = (T)midl;
                buf = buf.forvard;
            }
        }
    }
    /**
     * Методы итератора списка
     */
    private static class GenericIterator<T> implements Iterator<T>{
        Node<T> next;
        GenericIterator(Node<T> next){
            this.next = next;
        }
        @Override
        public boolean hasNext() {
            if(next!=null) return true;
            return false;
        }
        @Override
        public T next() {
            T value = (T)next.data;
            next = next.forvard;
            return value;
        }
    }
    /**
     * Вложенный класс, описывает узел двусвязного списка
     */
    private static class Node <T>{
        T data;
        Node<T> forvard;
        Node<T> backvard;

        public Integer toInteger(){
            if (data instanceof Integer){
                return (Integer)data;
            }else{
                throw new IllegalArgumentException("IllegalArgumentException: даные не относятся к типу Integer");
            }
        }
        public String toString(){
            if (data instanceof String){
                return (String)data;
            }else{
                throw new IllegalArgumentException("IllegalArgumentException: даные не относятся к типу String");
            }
        }
    }
}
