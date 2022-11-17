package ru.molokoin.j120.lab01.task1.vers03;

import java.util.regex.Pattern;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Phone{
    private Code code;
    private Number number;
    
    /**
     * Основной конструктор класса Phone<p>
     * @param code чтобы установить значение поля code
     * @param number чтобы установить значение поля number
     */
    public Phone(Code code, Number number){
        setCode(code);
        setNumber(number);
    }
    /**
     * Конструктор класса Phone, принимающий строковое значение номера телефона<p>
     * Разбивает строку на две части: code, number и передает их в конструкторы соответствующих классов,<p>
     * @param stringPhone
     */
    public Phone(String stringPhone){
        String[] phone = stringPhone.split(Pattern.quote(")"));
        code = new Code(phone[0]);
        setCode(code);
        number = new Number(phone[1]);
        setNumber(number);
    }
    /**
     * @param code the code to set
     */
    public void setCode(Code code) {
        this.code = code;
    }
    /**
     * @return the code
     */
    public Code getCode() {
        return code;
    }
    /**
     * @param number the number to set
     */
    public void setNumber(Number number) {
        this.number = number;
    }
    /**
     * @return the number
     */
    public Number getNumber() {
        return number;
    }
    
    /**
     * Переопределенный (@Override) метод класса Object,<p>
     * Проводит сравнение объекта у которого вызывается с переданным в качестве параметра метода объектом.<p>
     * Рекомендовано: всегда переопределять этот метод.
     */
    @Override
    public boolean equals(Object o){
        /**
         * Проверка, является ли переданный объект тем же,<p>
         * у которого был вызван метод equals()
         */
        if (this == o) return true;
        /**
         * Проверяем, был ли объект, переданный в метод создан на основании класса Phone
         */
        if(!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        /**
         * Провеяем, совпадают ли значения полей объекта у которого был вызван метод<p>
         * со значениями одноименных полей переданного в метод объекта
         */
        if ((this.code.getValue() == phone.code.getValue())&&(this.number.getValue() == phone.number.getValue())) return true;
        int i = 0;
        boolean bool = true;
        while(i < Phone.toIntArray(this).length){
            if(Phone.toIntArray(this)[i] != Phone.toIntArray(phone)[i]){
                bool = false;
            }
            i++;
        }
        if(bool)return true;
        return false;
    }
    /**
     * Статический метод, преобразовывает переданный в него объект класса Phone и возвращает int[]<p>
     * Предназначение - формирование ключевых полей, для передачи в hashMap
     * @param phone
     * @return
     * TODO доделать
     */
    public static int[] toIntArray(Phone phone){
        int[] code = phone.getCode().getValue();
        int[] number = phone.getNumber().getValue();
        int[] result = new int[code.length + number.length];
        /**
         * по хорошему надо найти метод, который добавляет поля нового массива к старому,
         * но пока так сделал ...
         */
        int i = 0;
        while (i < code.length){
            result[i] = code[i];
            i++;
        }
        int j = 0;
        while(j < number.length){
            result[i] = number[j];
            i++;
            j++;
        }
        return result;
    }
    /**
     * Возвращает строковое представление полного номера, для вывода пользователю в форматах:<p>
     * (000)000-00-00<p>
     * (0000)00-00-00<p>
     * <p>
     * код региона заключен в круглые скобки<p>
     * секции номера телефона разделены знаками "-"
     */
    public String toString(){
        return (getCode().toString() + getNumber().toString());
    }
    /**
     * Статический метод, дублирующий второй конструктор класса<p>
     * на основании строкового представления полного номера телефона<p>
     * формирует объект класса Phone и возвращает его в качестве результата выполнения метода
     * @param stringPhone для преобразования в объект Phone
     * @return Phone
     */
    public static Phone ofString(String stringPhone){
        String[] phone = stringPhone.split(Pattern.quote(")"));
        Code code = new Code(phone[0]);
        Number number = new Number(phone[1]);
        return new Phone(code, number);
    }
    /**
     * выводит в консоль оформленную со всеми необходимыми разделителями строку,<p>
     * содержащую полный номер телефона, хранящегося в текущем объекте
     */
    public void print(){
        System.out.println(toString());
    }
    /**
     * Возвращает уникальный(на период работы программы) идентификатор объекта,
     * возможно, для использования в качестве ключевого поля параметризованного списка
     */
    public int hashCode(){
        String s = Arrays.toString(Phone.toIntArray(this)).replaceAll(Regex.NON_DIGIT.get(), "");
        int hash = 0;
        try {
            hash =  Integer.parseInt(s);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка:" + e.getMessage());
            hash = 0;
        }
        return hash;
    }
    /**
     * На будущее: всегда переопределяем методы:<p>
     * equals()<p>
     * hashCode()<p>
     * toString()<p>
     * @param args
     */
    public static void main(String[] args) {
        Phone phone01 = new Phone("(812)337-33-13");
        System.out.println("Code array: " + Arrays.toString(phone01.getCode().getValue()));
        System.out.println("Number array: " + Arrays.toString(phone01.getNumber().getValue()));
        System.out.println("Тлефон в пользовательском виде: ");
        phone01.toString();
        phone01.print();
        System.out.println("hash-01 :" + phone01.hashCode());
        System.out.println("-------------------------------");
        Phone phone02 = new Phone("(8123)37-33-13");
        System.out.println("Code array: " + Arrays.toString(phone02.getCode().getValue()));
        System.out.println("Number array: " + Arrays.toString(phone02.getNumber().getValue()));
        System.out.println("Тлефон в пользовательском виде: ");
        phone02.toString();
        phone02.print();
        System.out.println("hash-02 :" + phone02.hashCode());
        System.out.println("-------------------------------");
        System.out.println("-------------------------------");
        System.out.println("Проверка взаимодействия класса с Асоциироанным массивом \"HashMap\"");
        
        //исходные номера телефонов
        System.out.println("Исходные номера телефонов: ");
        phone01 = new Phone("(812)337-33-13");
        //phone02 = new Phone("(8123)12-34-45");
        Phone phone03 = new Phone("(999)998-87-76");
        Phone phone04 = new Phone("(9999)98-87-76");
        phone01.print();
        phone02.print();
        phone03.print();
        phone04.print();
        System.out.println("-------------------------------");

        //создаем и заполняем асоциированный массив
        //не работает проверка уникальности ... проверяет хешкод int[], а не Phone
        //метод equals надо доработать, чтобы в нем вызывался массив, для сравнения.
        System.out.println("Создаем и заполняем асоциированный массив ...");
        HashMap<Integer, Phone> listMap = new HashMap<>();
        listMap.put(phone01.hashCode(), phone01);
        listMap.put(phone02.hashCode(), phone02);
        listMap.put(phone03.hashCode(), phone03);
        listMap.put(phone04.hashCode(), phone04);
        // выводим в консоль даные массива
        System.out.println("Выводим в консоль даные асоциированного массива ...");
        System.out.println(listMap);
        System.out.println("-------------------------------");
        
        //создаем и заполняем множество
        System.out.println("Создаем и заполняем множество ...");
        HashSet<Phone> listSet = new HashSet<>();
        listSet.add(phone01);
        listSet.add(phone02);
        listSet.add(phone03);
        listSet.add(phone04);
        // выводим в консоль даные множества
        System.out.println("Выводим в консоль даные множества");
        System.out.println(listSet);
        System.out.println("-------------------------------");

        System.out.println("phone01.equals(phone02)" + phone01.equals(phone02));
        System.out.println("phone01.equals(phone03)" + phone01.equals(phone03));

    }
}
