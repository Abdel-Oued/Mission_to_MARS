package fr.ensta.missiontomars;

import com.sun.org.apache.xerces.internal.impl.io.UTF8Reader;

import java.io.*;
import java.util.ArrayList;

public class simulation {
    private Object UTF8Reader;

    public ArrayList loadItems(String filename) {
        ArrayList itemsList = new ArrayList<Item>();
        try {
            File file = new File(filename);
            BufferedReader reader= new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line= reader.readLine();
            while (line != null){
                //itemsList.add(Item(name,weight));
                System.out.println(line);
                line = reader.readLine();

            }
            reader.close(); //pour arrêter la mémoire tampon
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        //finally{ //un bloc finally est toujours exécuté
            //if (br != null)
         //   if (file!= null)
          //      file.close(); //ferme le flux et libère les resources.
        //}
        return itemsList;
    }
}
