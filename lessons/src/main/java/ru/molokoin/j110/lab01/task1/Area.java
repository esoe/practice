package ru.molokoin.j110.lab01.task1;

public class Area {
    private String name;
    private int population;
    private int square;

    Area(){
        this(null, null, null);
    }
    Area(Object name, Object population, Object square){
        setName(name);
        setPopulation(population);
        setSquare(square);
    }
    public void print(){
        if (name != "") System.out.println("name: " + name);
        if (population > 0) System.out.println("population: " + population);
        if (square > 0) System.out.println("square: " + square);
    }
    /**
     * @param name the name to set
     */
    public void setName(Object name) {
        //преобразование Object
        try {
            if (name == null) throw new NullPointerException(getName());
        } catch (Exception e) {
            e.printStackTrace();
            this.name = "";
        } finally{
            if (name != null) this.name = (String)name;
        }
    }
    /**
     * @param population the population to set
     */
    public void setPopulation(Object population) {
        try {
            if (population == null) throw new NullPointerException("Параметр {население} не задан ...");
            
        } catch (NullPointerException e) {
            e.printStackTrace();
            this.population = 0;
        } finally{
            this.population = (Integer) population;
        }
    }
    /**
     * @param square the square to set
     */
    public void setSquare(Object square) {
        try {
            if (square == null) throw new NullPointerException("Параметр {площадь} не задан ...");
        } catch (NullPointerException e) {
            System.out.println("Наименвание не установлено ...");
            e.printStackTrace();
            this.square = 0;
        } finally{
            this.square = (Integer) square;
        }
        try {
            if (this.square < 0) throw new IllegalArgumentException("площадь не может быть отрицательной ...");
        
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            this.square = 0;
        }
    }
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    /**
     * @return the population
     */
    public int getPopulation() {
        return population;
    }
    /**
     * @return the square
     */
    public int getSquare() {
        return square;
    }
}
