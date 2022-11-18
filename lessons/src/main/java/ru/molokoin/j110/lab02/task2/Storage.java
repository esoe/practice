package ru.molokoin.j110.lab02.task2;

import java.util.Arrays;

/**
 * Класс - хранилище информации обо всех файлах
 * предоставляет инструментарий обращения с массивом файлов
 * TODO формат вывода преобразовать в табличный вид
 */
public class Storage {
    private File[] files;
    public Storage(){}
    public Storage(File[] files){
        setFiles(files);
    }
    public void setFiles(File[] files) {
        this.files = files;
    }
    public File[] getFiles() {
        return files;
    }
    public void print(){
        int i = 0;
        while (i < getFiles().length){
            getFiles()[i].print();
            i++;
        }
    }
    /**
     * Метод, добавляющий файл в хранилище/storage
     * @param file
     */
    public void add(File file) {
        if(getFiles() == null){
            File[] result = new File[1];
            result[0] = file;
            setFiles(result);
        }
        else{
            File[] result = Arrays.copyOf(getFiles(), getFiles().length+1);
            result[result.length - 1] = file;
            setFiles(result);
        }
    }
    public static void main(String[] args) {
        Storage storage = new Storage();
        //Заполняем массив исходными данными
        storage.add(new Document("myDocument", 10, Extension.DOCUMENT, "txt", 5));
        storage.add(new Image("myImage", 15, Extension.IMAGE, "jpg", new Dimensions(12, 8)));
        storage.add(new Audio("myAudio", 50, Extension.AUDIO, "mp3", "some melody", new Duration(20000)));
        storage.add(new Video("myVideo"
                , 100500
                , Extension.VIDEO
                , "mpeg"
                , "some video content"
                , new Duration(100500)
                , new Dimensions(1024, 768)));
        storage.print();
    }

}
