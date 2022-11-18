package ru.molokoin.j110.lab01.task1;

public class Map {
    public Country[] map; 
    //заполняем поля данными
    public void initDefaults(){
        map = new Country[5];
        //Россия
        map[0] = new Country("Russia", 146700000, 17100000, "Moscow", 12600000, 0);
        //Финляндия
        map[1] = new Country("Finland", 5500000, 338000, "Helsinki", 655000, 0);
        //Франция
        map[4] = new Country("France", 67800000, 643800, "Paris", 2100000, 0);

        //Андора
        map[3] = new Country("Andorra", 85000, 647, "Andorra la Vella", 22600, 0);

        //Сингапур
        map[2] = new Country("Singapore", 5700000, 725, null, 0, 0);
    }
    public static void printAll(Country[] map){
        System.out.println("printAll"); 
        System.out.println("Количество государств, данные о которых включены в terra: " + map.length);
        int i = 0;
        while (i < map.length) {
            Country.print(map[i]);
            i++;
        }
    }
    public static void main(String[] args) {
        System.out.println("Map.main()");
        Map terra = new Map();
        terra.initDefaults();
        printAll(terra.map);
    }
}
