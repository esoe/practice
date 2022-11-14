package ru.molokoin.j120.lab01.task1.vers01;

/**
 * Класс для зранения телефонного номера. 
 * 
 */
public class Phone {
    private int[] number;//массив цифр номера телефона
    private int[] code;//массив цифр кода региона
    //преобразовать строку в массив int
    public Phone(String phone){}
    public Phone(int[] code, int[] number){
        setCode(code);
        setNumber(number);
    }
    
    /**
     * @param code the digit to set
     */
    public void setCode(int[] code) {
        this.code = code;
    }
    /**
     * @return the digit
     */
    public int[] getCode() {
        return code;
    }
    /**
     * @param number the number to set
     */
    public void setNumber(int[] number) {
        this.number = number;
    }
    /**
     * @return the number
     */
    public int[] getNumber() {
        return number;
    }
    @Override
    public String toString() {
        String code = "";
        for (int i : this.code) {
            code = code + i;
        }
        String number = "";
        for (int i : this.number) {
            number = number + i;
        }
        String result;
        result = "(" + code + ")" + number;
        return result;
    }
    /**
     * Метод преобразует строку в объект Phone
     * содержимое скобок пишет в digit
     * содержимое после скобок пишет в number
     * @param phone
     * @return
     */
    public static Phone ofString(String phoneString){
        int[] code;
        int[] number;
        char[] c = phoneString.toCharArray(); 
        int i = 0;
        //определяем индексы плей, указывающих начало и окончание кода города
        int codeStart = 0;
        int codeStop = 0;
        while(i < c.length){
            if((c[i]) == "(".toCharArray()[0]){
                codeStart = i;
            }
            if((c[i]) == ")".toCharArray()[0]){
                codeStop = i;
            }
            i++;
        }
        System.out.println("digitStart : " + codeStart);
        System.out.println("digitStop : " + codeStop);
        //инициализация int[] number; определяем длину массива
        number = new int[c.length - codeStop - 1];
        //инициализация int[] digit
        code = new int[codeStop - 1];
        i = 0;
        int indexNumber = 0;
        int indexCode = 0;
        while (i < c.length){
            if (i > codeStop){
                number[indexNumber] = Character.getNumericValue(c[i]) ;
                indexNumber++;
            }
            if((i < codeStop)&&(i > codeStart)){
                code[indexCode] = Character.getNumericValue(c[i]);
                indexCode++;
            }
            i++;
        }
        Phone result = new Phone(code, number);
        return result;
    }
    
    /**
     * тесты методов класса Phone
     * @param args
     */
    public static void main(String[] args) {
        int[] d = {8, 1, 2};
        int[] n = {1, 2, 3, 4, 5, 6, 7};
        Phone p = new Phone(d, n);
        String phoneString = p.toString();
        System.out.println("phone : " + phoneString);
        System.out.println("phoneString.length() : " + phoneString.length());
        Phone pos = Phone.ofString("(495)3678792");
        System.out.println("pos : " + pos.toString());
    }
}
