package ru.molokoin.j110.lab01.task1;

public class Country extends Area{
    private Area capital;

    public Country() {
    }
    Country(Object name, Object population, Object square){
        super(name, population, square);
    }
    Country(String name, int population, int square, String capitalName, int capitalPopulation, int capitalSquare){
        //параметры страны
        super(name, population, square);
        //параметры столицы
        if (capitalName != null) setCapital(new Area(capitalName
                , capitalPopulation
                , capitalSquare));
        if (capitalName == null){
            setCapital(new Area(null
                , 0
                , 0));
        }
    }
    public static void print(Country country){
        System.out.println("-------------------------------------------");
        Area a = (Country) country;
        a.print();
        country.getCapital().print();
        System.out.println("-------------------------------------------");
    }
    public void getDanse(){
        //плотность населения в стране
        //population/square
    }

    public void clearCapital(){
        //очистка данных о столице
        
    }

    public void updateCapital(Country[] map){
        //обновление данных о столице
    }

    /**
     * @param сapital the сapital to set
     */
    public void setCapital(Area capital) {
        this.capital = capital;
    }

    /**
     * @return the сapital
     */
    public Area getCapital() {
        return capital;
    }
}
