package ru.molokoin.package01;
import java.util.Objects;

public class Binary {
    int size = 64/32;
    int[] ints = new int[size];

    public boolean getByIndex(int index){
        int indexElement = index/32;
        int element = ints[indexElement];
        int indexBit = index%32;//остаток от деления
        int mask = 1<<indexBit;
        return (element&mask)==mask;
    }
    @Override
    public String toString() {
        String[] tmp = new String[size];
        for (int i = 0; i < size; i ++){
            int x = getByIndex(i) ? 1:0;
            tmp[i] = Objects.toString(tmp);

        }
        return super.toString();
    }

    public static void main(String[] args) {
        Binary binary = new Binary();
    }
    
}
