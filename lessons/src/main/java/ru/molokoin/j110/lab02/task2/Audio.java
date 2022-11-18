package ru.molokoin.j110.lab02.task2;

/**
 * Класс, хранящий данные о аудиотреке/audio
 */
public class Audio extends File{
    private String format;
    private String content;
    private Duration duration;

    /**
     * Основной конструктор файлов аудио
     * @param name
     * @param size
     * @param extension
     * @param format
     * @param content
     * @param duration
     */
    public Audio(String name, int size, Extension extension, String format, String content, Duration duration) {
        super(name, size, extension);
        setFormat(format);
        setContent(content);
        setDuration(duration);
    }
    
    @Override
    public void print() {
        System.out.println("--------------------------------------------");
        super.print();
        System.out.println("format: " + getFormat());
        System.out.println("content: " + getContent());
        System.out.println("duration: " + getDuration().getSeconds() + " sec.");
    }
    /**
     * @return the format
     */
    public String getFormat() {
        return format;
    }
    /**
     * @param format the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }
    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }
    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
    /**
     * @return the duration
     */
    public Duration getDuration() {
        return duration;
    }
    /**
     * @param duration the duration to set
     */
    public void setDuration(Duration duration) {
        this.duration = duration;
    }
    
}
