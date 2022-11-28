/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rulespecs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author denis
 */
public class RulesPECS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RulesPECS rules = new RulesPECS();
        
        List<Country> countrys = new ArrayList<>();
        countrys.add(new Country());
        List<City> citys = new ArrayList<>();
        citys.add(new City());
        List<District> districts = new ArrayList<>();
        districts.add(new District());
        List<Street> streets = new ArrayList<>();
        streets.add(new Street());
        
        rules.producer(countrys);
        rules.producer(citys);
        rules.producer(districts);
        rules.producer(streets);
        
        rules.consumer(countrys);
        rules.consumer(citys);
        rules.consumer(districts);
        rules.consumer(streets);
    }
    
    public void producer (List<? extends District> list){
        list.add(new Country());
        list.add(new City());
        list.add(new District());
        list.add(new Street());
    }
    
    public void consumer (List<? super District> list){
        Object district = list.get(0);
        if(district instanceof Country) System.out.println("Object is Country");
        if(district instanceof City) System.out.println("Object is City");
        if(district instanceof District) System.out.println("Object is District");
        if(district instanceof Street) System.out.println("Object is Street");
        list.add(new Country());
        list.add(new City());
        list.add(new District());
        list.add(new Street());
    }
    
}
