package savinaAnLoad;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Exeptions.NotFile;


public class SavingFile<GettingData> implements Interf<GettingData>{

    public boolean saveFile(GettingData saveData, String lastName) {
    String nameFile = lastName + ".txt";
    try(FileWriter writer = new FileWriter(nameFile, true))
        {
           // запись всей строки
            writer.write(saveData.toString());
            writer.append('\n');
            writer.flush();
            return true;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return false;
        }
           
    }
    
    
    public void loadFile(String lastName) throws NotFile{
        String nameFile = lastName + ".txt";
        try(FileReader reader = new FileReader(nameFile))
        {
            int c;
            while((c=reader.read())!=-1){
            System.out.print((char)c);
        }
    }
        catch(FileNotFoundException e){
            throw new NotFile(nameFile);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }     
    }
}
