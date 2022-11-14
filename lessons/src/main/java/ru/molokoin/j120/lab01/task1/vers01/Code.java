package ru.molokoin.j120.lab01.task1.vers01;

public class Code {
    private int[]code;
    public Code(int[]code){
        setCode(code);
    }
    /**
     * @param code the code to set
     */
    public void setCode(int[] code) {
        this.code = code;
    }
    public static Code ofString(String codeString){
        char[] c = codeString.toCharArray();
        int[] code = new int[c.length-2];//исключили скобки
        int codeIndex = 0;
        for (char d : c) {
            if ((d != "(".toCharArray()[0]) && (d != ")".toCharArray()[0])){
                code[codeIndex] = Character.getNumericValue(d);
                codeIndex++;
            }
        }
        return new Code(code);
    }
    /**
     * @return the code
     */
    public int[] getCode() {
        return code;
    }
    @Override
    public String toString() {
        String result = "";
        String code = "";
        for (int i : this.code) {
            code = code + i;
        }
        result = "(" + code + ")";
        return result;
    }
    /**
     * Проверка функционала класса
     * @param args
     */
    public static void main(String[] args) {
        {String nums = "0123456789";
        char[] c = nums.toCharArray();
        for (char d : c) {
            System.out.println((int)d + " : " + Integer.toBinaryString(d));
        }
        System.out.println();}

        {String art = "()";
        char[] c = art.toCharArray();
        for (char d : c) {
            System.out.println((int)d + " : " + Integer.toBinaryString(d));
        }
        System.out.println();}
    }
}
