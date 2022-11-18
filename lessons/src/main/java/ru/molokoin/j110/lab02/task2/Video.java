package ru.molokoin.j110.lab02.task2;

/**
 * Класс, хранящий метаданные о видео/video
 */
public class Video extends Audio{
    private Dimensions dimensions;

    public Video(String name, int size, Extension extension, String format, String content, Duration duration, Dimensions dimensions) {
        super(name, size, extension, format, content, duration);
        setDimensions(dimensions);
    }
    @Override
    public void print() {
        super.print();
        System.out.println(dimensions.getWidth() + " x " + dimensions.getHeight());
    }
    /**
     * @param dimensions the dimensions to set
     */
    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
    /**
     * @return the dimensions
     */
    public Dimensions getDimensions() {
        return dimensions;
    }
    
}
