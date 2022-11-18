package ru.molokoin.j120.lab01.task2.vers01.generics;

import java.util.Iterator;

/**
 * Класс, устанавливающий методы рализации интерфейса Iterator,
 * устанавливает методы, испльзуемые при реализации метода iterator() интерфейса Iterable
 */
public class SimplyGenericListIterator<T> implements Iterator<T> {
    private final SimplyGenericList<T> currentList;
    private int index;

    SimplyGenericListIterator(SimplyGenericList<T> currentList){
        this.currentList = currentList;
        index = 0;
    }


    @Override
    public boolean hasNext() {
        return index < currentList.size();
    }

    @Override
    public T next() {
        //обрабатываем нулевое поле - head, которое установлено в конструкторе
        int i = 0;
        if (index == 0){
            index++;
            i++;
            return currentList.getHead().data;
        }
        //обрабатываем остальные значения, пока не дойдем до поля индекс
        SimplyGenericList<T>.Node<T> head = currentList.getHead();
        SimplyGenericList<T>.Node<T> current = head;
        while(i != (index)){
            current = current.next;
            i++;
        }
        index++;
        return current.data;
    }
}
