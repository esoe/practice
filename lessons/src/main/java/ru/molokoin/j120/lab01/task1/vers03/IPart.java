package ru.molokoin.j120.lab01.task1.vers03;

public interface IPart {
    public static String regex = "";
    public abstract int[] getValue();
    public abstract void setValue(int[] value);
    public abstract int[] ofString(String string);
    public abstract String toString();
    public abstract void print();
}
