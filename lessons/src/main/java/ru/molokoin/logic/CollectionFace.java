package ru.molokoin.logic;

/**
 * Интерфейс булевого массива
 */
public interface CollectionFace {
    public static int size = 1024;

    /**
     * проверка элемента с заданным индексом
     * @param index
     * @return
     */
    public abstract boolean isContain(int index);

    /**
     * установка (в true) элемента с заданным индексом
     * @param index
     */
    public abstract void setTrueByIndex(int index);

    /**
     * сброс (в false) элемента с заданным индексом
     * @param index
     */
    public abstract void setFalseByIndex(int index);

    /**
     * установка элемента с заданным индексом заданным логическим значением
     * @param index
     */
    public abstract void setValueByIndex(int index, int value);

    /**
     * инвертирование элемента с заданным индексом
     * @param index
     */
    public abstract void invertByIndex(int index);

    /**
     * метод, возвращающий количество элементов, установленных в true
     * @return
     */
    public abstract int countOfTrue();

    /**
     * метод toString(), возвращающий последовательность нулей и единиц, где каждый сим-
вол представляет значение соответствующего элемента массива
     */
    public abstract String toString();


}
