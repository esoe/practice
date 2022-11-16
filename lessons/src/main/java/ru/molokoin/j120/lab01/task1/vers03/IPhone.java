package ru.molokoin.j120.lab01.task1.vers03;

public interface IPhone {
    public abstract Boolean equals(Phone phone);
    public static int[] toIntArray(Phone phone){
        return null;
    }
    public static String toString(Phone phone){
        return (phone.getCode().toString() + phone.getNumber().toString());
    }
    public static Phone ofString(String stringPhone){
        String[] phone = stringPhone.split(")");
        Code code = new Code(phone[0]);
        Number number = new Number(phone[1]);
        return new Phone(code, number);
    }
}
