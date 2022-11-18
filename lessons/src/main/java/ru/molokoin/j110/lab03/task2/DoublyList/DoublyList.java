package ru.molokoin.j110.lab03.task2.DoublyList;

import java.util.ArrayList;
import java.util.Arrays;

public class DoublyList {
    private Node head = null;
    private Node tail = null;

    /**
     * метод проверяет пустой ли список и в случае,
     * если в списке нет узла head, возвращает true.
     * Если узел head есть, но в нем отсудствую данные, также возвращается true.
     * @return
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
    public void addFirst(Integer data){
        if (isEmpty()) {
            Node newNode = new Node();
            newNode.data = data;
            setHead(newNode);
            setTail(newNode);
        }else{
            Node newNode = new Node();
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
    public void addLast(Integer data){
        if (isEmpty()) {
            Node newNode = new Node();
            newNode.data = data;
            setHead(newNode);
            setTail(newNode);
        }else{
            Node newNode = new Node();
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
        Node tmp = getHead();
        while (tmp != null){
            printNode(tmp);
            tmp = tmp.forvard;
        }
    }
    public void printBackvard(){
        Node tmp = getTail();
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
    public void printNode(Node node){
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
    public Integer executeFirst(){
        Integer executed = null;
        if (isEmpty()){
            return executed;
        }
        else{
            try {
                executed = getHead().data;
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
    public Integer executeLast(){
        Integer executed = null;
        if (isEmpty()){
            return executed;
        }
        else{
            try {
                executed = getTail().data;
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
    public boolean isContain(Integer value){
        boolean isContain = false;
        if (isEmpty()){
            isContain = false;
            return isContain;
        }
        else{
            Node tmp = getHead();
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
    public void deleteByValue(Integer value){
        //проверяем наличие указанного значения в списке
        if (isContain(value)){
            //удаляем первые ноды, если они содержат указанное значение
            Node tmp = getHead();
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
    public void arrayToHead(Integer[]array){
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
    public void arrayToTail(Integer[]array){
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
    public void collectionToHead(ArrayList<Integer> collection){
        for(int i = (collection.size()-1);i >= 0;i--) {
            addFirst(collection.get(i));
        }
    }
    /**
     * добавление коллекции в хвост списка
     * @param collection
     */
    public void collectionToTail(ArrayList<Integer> collection){
        for(Integer c : collection){
            addLast(c);
        }
    }
    public Node getHead() throws NullPointerException {
        return head;
    }
    public void setHead(Node head) {
        this.head = head;
    }
    public Node getTail() throws NullPointerException{
        return tail;
    }
    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * Вложенный класс, описывает узел двусвязного списка
     */
    private class Node{
        Integer data;
        Node forvard;
        Node backvard;
    }
    public static void main(String[] args) {
        System.out.println("Запущен поток: " + Thread.currentThread().getName());
        //создаем пустой список
        System.out.println("создаем новый список ...");
        DoublyList list = new DoublyList();
        //проверяем пустой ли список
        System.out.println("проверяем пустой ли список ...");
        System.out.println("isEmpty() >>> " + list.isEmpty());

        //добавляем данные в начало списка
        System.out.println("добавляем данные в начало списка ...");
        list.addFirst(23);
        list.addFirst(12);
        list.addFirst(7);

        //добавляем данные в конец списка
        System.out.println("добавляем данные в конец списка ...");
        list.addLast(27);
        list.addLast(32);
        list.addLast(34);
        list.addLast(62);
        list.addLast(117);
        
        //проверяем пустой ли список
        System.out.println("проверяем пустой ли список ...");
        System.out.println("isEmpty() >>> " + list.isEmpty());

        //выводим в консоль данные списка
        System.out.println("выводим в консоль данные списка ...");
        list.printForvard();

        //удаляем первый элемент списка
        System.out.println("удаляем первый элемент списка ..." + list.executeFirst());
        //выводим в консоль данные списка
        System.out.println("выводим в консоль данные списка ...");
        list.printForvard();

        //удаляем последний элемент списка
        System.out.println("удаляем последний элемент списка ..." + list.executeLast());
        //выводим в консоль данные списка
        System.out.println("выводим в консоль данные списка ...");
        list.printForvard();

        //проверяем наличие значения в списке
        int i = 23;
        System.out.println("Проверяем наличие значения в списке ... " + i);
        System.out.println("результат проверки: " + list.isContain(i));
        i = 0;
        System.out.println("Проверяем наличие значения в списке ... " + i);
        System.out.println("результат проверки: " + list.isContain(i));

        //удаляем поле по заданному значению
        i = 32;
        System.out.println("удаляем элементы списка со значением ... " + i);
        list.deleteByValue(i);
        //выводим в консоль данные списка
        System.out.println("выводим в консоль данные списка ...");
        list.printForvard();

        //массив с исходными данными
        System.out.println("создаем новый массив arrays ...");
        Integer[] array= {12, 22, 134,276,358,421,587,636,785,981};
        System.out.println("содержащий данные: " + Arrays.toString(array));
        System.out.println("добавляем массив в начало списка ...");
        list.arrayToHead(array);
        //выводим в консоль данные списка
        System.out.println("выводим в консоль данные списка ...");
        list.printForvard();
        
        //добавляем данные массива в конец списка
        System.out.println("добавляем массив в конец списка ...");
        list.arrayToTail(array);
        //выводим в консоль данные списка
        System.out.println("выводим в консоль данные списка ...");
        list.printForvard();

        //добавляем коллекцию в конец списка
        System.out.println("добавляем коллекцию в конец списка ...");
        ArrayList<Integer> collection = new ArrayList<Integer>();
        collection.add(100);
        collection.add(200);
        collection.add(300);
        collection.add(400);
        collection.add(500);
        collection.add(600);
        list.collectionToTail(collection);
        list.printForvard();

        //добавляем коллекцию в начало списка
        System.out.println("добавляем коллекцию в начало списка ...");
        list.collectionToHead(collection);
        list.printForvard();

        //печатаем список в обратном порядке
        System.out.println("печатаем список в обратном порядке ...");
        list.printBackvard();
        

        

    }
}
