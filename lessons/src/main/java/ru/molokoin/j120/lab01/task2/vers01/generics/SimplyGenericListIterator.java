package ru.molokoin.j120.lab01.task2.vers01.generics;

import java.util.Iterator;

import ru.molokoin.j120.lab01.task2.vers01.generics.SimplyGenericList.Node;

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
        int i = 0;
        if (index == 0){
            index++;
            i++;
            return currentList.getHead().data;
        }
        SimplyGenericList<T>.Node head = currentList.getHead();
        SimplyGenericList<T>.Node current = head;
        while(i != (index)){
            current = current.next;
            i++;
        }
        index++;
        return current.data;
    }
}
