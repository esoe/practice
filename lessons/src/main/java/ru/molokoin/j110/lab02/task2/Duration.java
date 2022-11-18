package ru.molokoin.j110.lab02.task2;

/**
 * Класс хранит данные о длительности (аудио/видео).
 * TODO подготовить формат возвращаемого значения в виде: ХХ мин. ХХ сек.
 */
public class Duration {
    private long milliseconds;
    public Duration(long milliseconds){
        setMilliseconds(milliseconds);
    }
    public void print(){
        System.out.println(getSeconds() + "секунд.");
    }
    /**
     * Возвращает время в секундах
     * @return
     */
    public long getSeconds(){
        return getMilliseconds()/1000;
    }

    /**
     * @param milliseconds the milliseconds to set
     */
    public void setMilliseconds(long milliseconds) {
        this.milliseconds = milliseconds;
    }
    /**
     * @return the milliseconds
     */
    public long getMilliseconds() {
        return milliseconds;
    }
    
}
