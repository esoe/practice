package ru.molokoin.j110.lab01.task2;

public class Book {
    private String name;
    private Publisher publisher;
    private int year;
    private String[] authors;

    Book(){}
    Book(String name, int year, Publisher publisher){}
    Book(String name, String author, int year, Publisher publisher){
        this(name, year, publisher);
        uppendAuthors(author);
    }
    Book(String name, String[] authors, int year, Publisher publisher){
        this(name, year, publisher);
        String[] a = authors;
        setAuthors(a);
    }
    /**
     * Создаем массив книг, заполняем книги данными по умолчанию
     * и возвращаем массив книг
     * @return
     */
    public static Book[] getDefaultArray(){
        Book[] books = new Book[5];

        //book 1
        String name = "Computer Science: основы программирования на Java, ООП, алгоритмы и структуры данных";
        books[0] = new Book();
        books[0].setName(name);
        books[0].uppendAuthors("Седжвик Роберт");
        books[0].uppendAuthors("Уэйн Кевин");
        books[0].setPublisher(Publisher.getPublisherByName(Publisher.getDefaultArray(), "Питер"));
        books[0].setYear(2018);

        //book 2
        name = "Разработка требований к программному обеспечению. 3-е издание, дополненное";
        books[1] = new Book();
        books[1].setName(name);
        books[1].uppendAuthors("Вигерс Карл");
        books[1].setPublisher(Publisher.getPublisherByName(Publisher.getDefaultArray(), "БХВ"));
        books[1].setYear(2019);

        //book 3
        name = "Java. Полное руководство, 10-е издание";
        books[2] = new Book();
        books[2].setName(name);
        books[2].uppendAuthors("Шилдт Гербертт");
        books[2].setPublisher(Publisher.getPublisherByName(Publisher.getDefaultArray(), "Диалектика"));
        books[2].setYear(2018);

        //book 4
        name = "C/C++. Процедурное программирование";
        books[3] = new Book();
        books[3].setName(name);
        books[3].uppendAuthors("Полубенцева М.И.");
        books[3].setPublisher(Publisher.getPublisherByName(Publisher.getDefaultArray(), "БХВ"));
        books[3].setYear(2017);

        //book 5
        name = "Конституция РФ";
        books[4] = new Book();
        books[4].setName(name);
        books[4].setPublisher(Publisher.getPublisherByName(Publisher.getDefaultArray(), "Проспект"));
        books[4].setYear(2020);

        return books;
    }
    /**
     * Печатть данных о книге в консоль
     */
    public void print(){
        System.out.println("-------------------------------");
        System.out.println("Наименование книги (name) :: " + name);
        getPublisher().print();
        System.out.println("Год издания (year) :: " + year);
        System.out.println("Авторы: " + getAuthorsCount(authors) + " человек ...");
        int i = 0;
        while (i < getAuthorsCount(authors)){
            System.out.println((i + 1) + ". " + getAuthors()[i]);
            i++;
        }
        System.out.println("-------------------------------");
    }
    /**
     * Добавляем авторов книги
     * @param author
     */
    public void uppendAuthors(String author){
        String[] result;
        /**
         * в случае, если массив authors еще не создан и писать нового автора некуда,
         * создаем пустой массив, пишем в него данные нового автора
         */
        if (getAuthors() == null){
            try {
                throw new NullPointerException("в случае, если массив authors еще не создан и писать нового автора некуда, создаем пустой массив, пишем в него данные нового автора ...");
            } catch (NullPointerException e) {
                //e.printStackTrace();
                System.out.println(e.getMessage());
                result = new String[1];
                result[0] = author;
                setAuthors(result);
            }
        }
        /**
         * Если массив авторов книги уже существует, создаем новый массив с увеличенным на единицу
         * количеством полей и переписываем в него данные старого массива,
         * после чего добавляем в него новую запись.
         */
        else{
            int count = getAuthorsCount(authors);
            result = new String[count +1];
            //переписываем данные старого массива
            int i = 0;
            while (i < count){
                result[i] = getAuthors()[i];
                i++;
            }
            //добавляем нового автора
            result[count] = author;
            setAuthors(result);
        }
    }
    /**
     * Возвращает данные поля author, по индексу поля в массиве
     * индексы нумеруются с нуля и не могут быть отрицательными.
     * @param index
     * @return
     */
    public String getAuthorByIndex(int index){
        //при получении отрицательного индекса, меняем его значение на ноль, сообщаем пользователю о проведеных изменениях
        if (index < 0){
            try {
                throw new IllegalArgumentException("В метод public String getAuthorByIndex(int index) передано значение меньше нуля, массив не может содержать отрицательное количество полей. Значение индекса исправлено на значение по умолчанию: 0 ...");
                
            } catch (Exception e) {
                e.printStackTrace();
                index = 0;
            }
        }
        String author = getAuthors()[index];
        return author;
    }
    /**
     * возвращает количество авторов книги
     * @param authors
     * @return
     */
    public static int getAuthorsCount(String[] authors){
        //проверяем, имеется ли записи в перечне авторов
        int count = 0;
        try {
            if (authors == null) throw new NullPointerException ("Авторы книги не установлены ...");
        } catch (Exception e) {
            //e.printStackTrace();
            count = 0;
        }
        if (authors != null) count = authors.length;
        return count;
    }
    /**
     * Устанавливаем название книги
     * @param name the name to set
     */
    public void setName(String name) {
        // название книги не должно быть пустой ссылкой
        if (name == null){
            try {
                throw new NullPointerException("В качестве названия книги передана пустая ссылка, полю установлено значение по умолчанию {noname book}");
            } catch (NullPointerException e) {
                System.out.println("Ошибка: " + e);
                e.printStackTrace();
                this.name = "noname book";
            }
        }else {
            this.name = name;
        }
    }
    /**
     * Устанавливаем данные об издательстве.
     * издательство не должно быть пустой ссылкой
     * @param publisher the publisher to set
     */
    public void setPublisher(Publisher publisher) {
        if (publisher == null){
            try {
                throw new NullPointerException("Передана пустая ссылка, при внесении данных об издательстве, что недопустимо. Установлено знаение издательства по умолчанию.");
            } catch (NullPointerException e) {
                e.printStackTrace();
                System.out.println("Ошибка: " + e);
                this.publisher = new Publisher();
            }
        }else{
            this.publisher = publisher;
        }
    }
    /**
     * устанавливаем год издания книги
     * - год издания должен быть строго больше нуля
     * @param year the year to set
     */
    public void setYear(int year) {
        if (year < 0){
            try{
                throw new IllegalArgumentException("В качестве года издания книги указан значение еньше нуля. Значение заменен на значение по умолчанию {1800}");
            } catch (IllegalArgumentException e){
                e.printStackTrace();
                System.out.println("Ошибка: " + e);
                year = 1800;
            }
        }else {
            this.year = year;
        }
    }
    /**
     * Устанавливаем перечень авторов книги
     * @param author the author to set
     */
    public void setAuthors(String[] authors) {
        try {
            if (authors == null) throw new NullPointerException("setAuthors() ... передан пустой список авторов");
        } catch (NullPointerException e) {
            e.printStackTrace();
            this.authors = new String[0];
        } finally {
            this.authors = authors;
        }
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the publisher
     */
    public Publisher getPublisher() {
        return publisher;
    }
    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }
    /**
     * @return the author
     */
    public String[] getAuthors() {
        return this.authors;
    }
    public static void main(String[] args) {
        Book[] books = Book.getDefaultArray();
        //Вывод данных по умолчанию
        int i = 0;
        while (i < books.length){
            books[i].print();
            i++;
        }
        
        //исправляем данные о городе издательства БХВ
        String wrightSity = "Санкт-Петербург";
        String wrongSity = "Санкт-Петебург";
        i = 0;
        while (i < books.length){
            if (books[i].getPublisher().getSity() == wrongSity){
                books[i].getPublisher().setSity(wrightSity);
            }
            i++;
        }

        //пояснения пользователю
        System.out.println("#############################################");
        System.out.println("Вывод изменился для всех книг, изданных издательством \"БХВ\".");
        System.out.println("Устранена опечатка в наименовании города. \"Санкт-Петебург\" заменено на \"Санкт-Петербург\". " + "Была пропущена буква: \"Б\".");
        System.out.println("#############################################");

        //Вывод исправленных данных
        i = 0;
        while (i < books.length){
            books[i].print();
            i++;
        }
    }
}
