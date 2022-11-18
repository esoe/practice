package ru.molokoin.j110.lab02.task2;

/**
 * Класс, хранящий метаданные о изображении/image
 */
public class Image extends File{
    private String format;
    private Dimensions dimensions;

    public Image(String name, int size, Extension extension, String format, Dimensions dimensions) {
        super(name, size, extension);
        init(format, dimensions);
    }
    @Override
    public void print(){
        System.out.println("--------------------------------------------");
        super.print();
        System.out.println("format: " + getFormat());
        System.out.println("Dimensions: " + getDimensions().getHeight() + " x " + getDimensions().getWidth());
    }
    public void init(String format, Dimensions dimensions){
        setFormat(format);
        setDimensions(dimensions);
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }
    public String getFormat() {
        return format;
    }
    public Dimensions getDimensions() {
        return dimensions;
    }
    
}
