/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propertiesexample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class PropertiesExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File fileProp = new File("prop.properties");
        if(!fileProp.exists()) try {
            fileProp.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(fileProp));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        properties.put("key", "key value");
//        properties.put("key", "key value2");
//        properties.put("key2", "key value2");
        
        System.out.println(properties.getProperty("nameK", "Key is not exist"));
        
        try {
            properties.store(new FileWriter(fileProp), null);
        } catch (IOException ex) {
            Logger.getLogger(PropertiesExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
