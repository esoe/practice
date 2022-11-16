package ru.molokoin.j120.lab01.task1.vers03;

import java.util.regex.Pattern;
import java.util.Objects;

public class Phone{
    private Code code;
    private Number number;
    
    public Phone(Code code, Number number){
        setCode(code);
        setNumber(number);
    }
    public Phone(String stringPhone){
        String[] phone = stringPhone.split(Pattern.quote(")"));
        System.out.println("Part one: " + phone[0]);
        System.out.println("Part two: " + phone[1]);
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
    
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if(!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        if ((this.code.getValue() == phone.code.getValue())&&(this.number.getValue() == phone.number.getValue())) return true;
        return false;
    }
    public static int[] toIntArray(Phone phone){
        return null;
    }
    public String toString(){
        return (getCode().toString() + getNumber().toString());
    }
    public static Phone ofString(String stringPhone){
        String[] phone = stringPhone.split(Pattern.quote(")"));
        Code code = new Code(phone[0]);
        Number number = new Number(phone[1]);
        return new Phone(code, number);
    }
    public void print(){
        System.out.println(toString());
    }
    /**
     * TODO посмотреть реализацию
     * 
     */
    public int hashCode(){
        return Objects.hash(code, number);
    }
    /**
     * Всегда переопределяем методы<p>
     * equals()<p>
     * hashCode()<p>
     * toString()<p>
     * @param args
     */
    public static void main(String[] args) {
        Phone phone = new Phone("(812)337-33-13");
        phone.toString();
        phone.print();
    }
    
}
