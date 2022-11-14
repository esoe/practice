package ru.molokoin.j120.lab1.task1;

import java.util.HashSet;

public class Phone {
    private int[] number = new int[10];//массив цифр номера телефона
    /**
     * true - трехзначный код
     * false - двухзначный код
     */
    private int digitCode;

    public Phone(int digitCode, String number){
        setNumber(number);
        setDigitCode(digitCode);
    }
    /**
     * @param digitCode the digitCode to set
     */
    public void setDigitCode(int digitCode) {
        this.digitCode = digitCode;
    }
    /**
     * @param number the number to set
     */
    public void setNumber(String number) {
        System.out.println("setNumber(String number) starts ...");
        int i = 0;
        for (char c : number.toCharArray()) {
            this.number[i] = ((int)c);
            System.out.print(c);
            i++;
        }
        System.out.println();
        System.out.println("setNumber(String number) finished!");
    }
    /**
     * @return the digitCode
     */
    public int getDigitCode() {
        return digitCode;
    }
    /**
     * @return the number
     */
    public int[] getNumber() {
        return number;
    }
    @Override
    public String toString() {
        System.out.println("toString() Starts ...");
        String s = "";
        for (int i : number) {
            s = s + (i);
        }
        return s;
    }
    public static void main(String[] args) {
        System.out.println("Running thread ... " + Thread.currentThread().getName());
        HashSet<Phone> phoneSet = new HashSet<Phone>();
        phoneSet.add(new Phone(3, "1234567890"));
        phoneSet.add(new Phone(4, "2345678901"));
        for (Phone phone : phoneSet) {
            System.out.println(phone.toString());
            
        }

    }
}
