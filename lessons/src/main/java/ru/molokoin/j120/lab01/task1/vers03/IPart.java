package ru.molokoin.j120.lab01.task1.vers03;

/**
 * интерфейс IPart, прдусматривает основные методы,<p>
 * для работы с секциями полного номера телефона
 */
public interface IPart {
    public abstract int[] getValue();
    public abstract void setValue(int[] value);
    public abstract String toString();
    public abstract void print();
    /**
     * метод убирает все не числовые поля в строке, <p>
     * преобразует полученную строку в int[],<p>
     * который возвращает в качестве результата выполнения метода.
     * @param string
     * @return
     */
    public static  int[] ofString(String string){
        String s = string.replaceAll(Regex.NON_DIGIT.get(), "");
        int[] result = new int[s.length()];
        int i = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            result[i] = Character.getNumericValue(c);
            i++;
        }
        return result;
    }
}
