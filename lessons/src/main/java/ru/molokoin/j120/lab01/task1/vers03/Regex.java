package ru.molokoin.j120.lab01.task1.vers03;

public enum Regex {
    /**
     * DIGIT.get()<p>
     * Регулярное выражение: [0-9]<p>
     * Выбираем все числовые элементы
     */
    DIGIT("[0-9]"),
    /**
     * NON_DIGIT.get()<p>
     * Регулярное выражение: [^0-9]<p>
     * Выбираем все не числовые элементы
     */
    NON_DIGIT("[^0-9]");

    private String code;
    Regex(String code){
        this.code = code;
    }
    public String get(){
        return code;
    }
    
}
