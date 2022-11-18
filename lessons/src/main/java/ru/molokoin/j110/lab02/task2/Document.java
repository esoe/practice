package ru.molokoin.j110.lab02.task2;

/**
 * Класс, хранящий метаданные о документе/document
 */
public class Document extends File{
    private String format;
    private int lists;

    /**
     * Основной конструктор документа
     * @param name
     * @param size
     * @param extension
     * @param format
     * @param lists
     */
    public Document(String name, int size, Extension extension,String format, int lists) {
        super(name, size, extension);
        setFormat(format);
        setLists(lists);
    }

    @Override
    public void print(){
        System.out.println("--------------------------------------------");
        super.print();
        System.out.println("format: " + getFormat());
        System.out.println("lists: " + getLists());
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public String getFormat() {
        return format;
    }
    public void setLists(int lists) {
        this.lists = lists;
    }
    public int getLists() {
        return lists;
    }
}
