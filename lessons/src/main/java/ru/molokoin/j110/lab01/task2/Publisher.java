package ru.molokoin.j110.lab01.task2;

public class Publisher {
    private String name;
    private String sity;
    Publisher(){
        this(null, null);
    }

    Publisher(String name, String sity){
        setName(name);
        setSity(sity);
    }
    /**
     * Метод класса. Возвращает массив данных об издательствах по умолчанию
     * @return
     */
    public static Publisher[] getDefaultArray(){
        Publisher[] defaultPublishers = new Publisher[4];
        defaultPublishers[0] = new Publisher("Проспект", "Москва");
        defaultPublishers[1] = new Publisher("Питер", "Санкт-Петербург");
        defaultPublishers[2] = new Publisher("БХВ", "Санкт-Петебург");
        defaultPublishers[3] = new Publisher("Диалектика", "Киев");
        return defaultPublishers;
    }
    /**
     * выводим в консоль данные Издательства
     */
    public void print(){
        System.out.println("Издательство: " + getName()  + " ----> " + "город: " + getSity());
    }
    /**
     * @param name the name to set
     * DONE: имя издательства не олжно быть пустой ссылкой
     */
    public void setName(String name) {
        String defaultName = "noname publisher";
        try {
            if (name == null) throw new NullPointerException("Имя издательства не задано пользователем. Установлено значение поля по умолчанию {noname publisher} ...");
        }catch (NullPointerException e){
            setName(defaultName);
        }finally {
            this.name = name;
        }
    }
    /**
     * Устанавливаем наименование города - где находится издательство
     * Наименование города издания не должно быть пустой ссылкой
     * @param sity the sity to set
     */
    public void setSity(String sity) {
        String defaultSity = "noname sity";
        try {
            if (sity == null) throw new NullPointerException("Наименование города не задано пользователем. Установлено значение поля по умолчанию {noname sity} ...");
        } catch (Exception e) {
            setSity(defaultSity);
        }finally{
            this.sity = sity;
        }
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the sity
     */
    public String getSity() {
        return sity;
    }
    public static Publisher getPublisherByName(Publisher[] publishers, String name){
        Publisher publisher = new Publisher();
        boolean isAcsists = false;
        int i = 0;
        while (i < publishers.length){
            if (name.equals((String)publishers[i].getName())){
                publisher = publishers[i];
                isAcsists = true;
            }
            i++;
        }
        try {
            if(!isAcsists) throw new Exception("Указанное наименование издательства не найдено в каталоге. Установлено наименование города по умолчанию {noname sity} ...");
        } catch (Exception e) {
            publisher = new Publisher(name, null);
        }
        return publisher;
    }
    public static void main(String[] args) {
        Publisher[] publishers = Publisher.getDefaultArray();
        int i = 0;
        while (i < publishers.length){
            publishers[i].print();
            i++;
        }
    }
    
}
