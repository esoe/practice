package ru.molokoin.j120.lab01.task1.vers03;

public class Phone{
    private Code code;
    private Number number;
    
    public Phone(Code code, Number number){
        setCode(code);
        setNumber(number);
    }
    public Phone(String stringPhone){
        String[] phone = stringPhone.split(")");
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
    
    public Boolean equals(Phone phone) {
        // TODO Auto-generated method stub
        return null;
    }
    public static void main(String[] args) {
        Phone phone = new Phone("(812)337-33-13");
        IPhone.toString(phone);
    }
    
}
