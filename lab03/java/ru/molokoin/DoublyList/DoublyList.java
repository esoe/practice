package ru.molokoin.DoublyList;

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
    public void printAll(){
        Node tmp = getHead();
        while (tmp != null){
            printNode(tmp);
            tmp = tmp.forvard;
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
    public void deleteByValue(Integer value){
        if (isContain(value)){
            Node tmp = getHead();
            while (tmp.data == value){
                executeFirst();
                tmp = getHead();
            }
            tmp = getTail();
            while(tmp.data == value){
                executeLast();
                tmp = getTail();
            }
            tmp = getHead();
            while (tmp.forvard != null){
                if (tmp.forvard.data == value){
                    //tmp.forvard = tmp.forvard.forvard;
                }
                tmp = tmp.forvard;
                
            }
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
        list.printAll();

        //удаляем первый элемент списка
        System.out.println("удаляем первый элемент списка ..." + list.executeFirst());
        //выводим в консоль данные списка
        System.out.println("выводим в консоль данные списка ...");
        list.printAll();

        //удаляем последний элемент списка
        System.out.println("удаляем последний элемент списка ..." + list.executeLast());
        //выводим в консоль данные списка
        System.out.println("выводим в консоль данные списка ...");
        list.printAll();

        //проверяем наличие значения в списке
        int i = 23;
        System.out.println("Проверяем наличие значения в списке ... " + i);
        System.out.println("результат проверки: " + list.isContain(i));
        i = 0;
        System.out.println("Проверяем наличие значения в списке ... " + i);
        System.out.println("результат проверки: " + list.isContain(i));

    }
}
