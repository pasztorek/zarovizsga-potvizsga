package hu.nive.ujratervezes.zarovizsga;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class People {


   public int getNumberOfMales(String path) {
       String line = "";
       int male = 0;


       try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {

           while ((line = reader.readLine()) != null) {

               if (line.contains(",Male,")) {
                   male++;
               }

           }

       } catch (IOException ioe) {
           throw new IllegalStateException("Can not read file", ioe);

       }
       return male;
   }
}
