package ru.molokoin.logic;

public class IntCollection implements CollectionFace{
    int box = 32;//количество бит выделенное под значение типа integer
    int[] collection = new int[size/box];//1024 (размер булевого массива)/32 (размер блока, для формирования интового значения)

    /**
     * index - варьирует от 0 до 1024 (весь булевский массив)
     */
    @Override
    public boolean isContain(int index) {
        int collectionIndex = index/box;//номер бокса
        int value = collection[collectionIndex];//бит, с которого начинается бокс
        int indexBit = index%32;//остаток от деления - адрес бита в боксе
        int mask = 1<<indexBit;






        return false;
    }

    @Override
    public void setTrueByIndex(int index) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setFalseByIndex(int index) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setValueByIndex(int index, int value) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void invertByIndex(int index) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public int countOfTrue() {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
