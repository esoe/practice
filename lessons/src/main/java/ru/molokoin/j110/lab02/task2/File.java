package ru.molokoin.j110.lab02.task2;

/**
 * Класс - обертка
 */
public class File {
    private String name;
    private int size;
    private Extension extension;
    public File(String name, int size, Extension extension){
        setName(name);
        setSize(size);
        setExtension(extension);
    }
    public void print(){
        System.out.println("name: " + getName());
        System.out.println("size: " + getSize() + "byte");
        System.out.println("extension: " + extension);
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setExtension(Extension extension) {
        this.extension = extension;
    }
    public String getName() {
        return name;
    }
    public int getSize() {
        return size;
    }
    public Extension getExtension() {
        return extension;
    }
}
