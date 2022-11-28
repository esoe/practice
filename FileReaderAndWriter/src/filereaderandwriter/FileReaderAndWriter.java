/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filereaderandwriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author denis
 */
public class FileReaderAndWriter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("Text.txt");
        if(!file.exists()) try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(FileReaderAndWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(file.canWrite()){
            
            String line = "Hello world!";
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.append("\n" + line);
            } catch (IOException ex) {
                Logger.getLogger(FileReaderAndWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        if(file.canRead()){
            String line = "";
            try(FileReader reader = new FileReader(file)){
                
                char[]buf = new char[5];
                int c =0;
                while((c=reader.read(buf))!=-1){
                    line += new String(buf, 0, c);
                }
                
            }catch (IOException ex) {
                Logger.getLogger(FileReaderAndWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(line);
        }
    }
    
}
