package fr.ensta.missiontomars;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Simulation {

    public ArrayList<Item> loadItems(String filename) {
        ArrayList<Item> itemsList = new ArrayList<Item>();
        try {
            File file = new File(filename);
            BufferedReader reader= new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line= reader.readLine();
            while (line != null){
                String[] splitedLine = line.split("=");
                String name = splitedLine[0];
                int weight = Integer.parseInt(splitedLine[1]) / 1000; // on convertit en tonnes
                itemsList.add(new Item(name,weight));
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

    public ArrayList<Rocket> loadU1(ArrayList<Item> itemsList){
        ArrayList<Rocket> u1List = new ArrayList<>();
        U1 u1 = new U1();
        u1List.add(u1);

        ListIterator<Item> iterItem = itemsList.listIterator();
        while (iterItem.hasNext()){
            if(!u1.canCarry(iterItem.next())) {
                u1 = new U1();
                u1List.add(u1);
            }
            u1.carry(iterItem.next());
        }
        return u1List;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemsList){
        ArrayList<Rocket> u2List = new ArrayList<>();
        U2 u2 = new U2();
        u2List.add(u2);

        ListIterator<Item> iterItem = itemsList.listIterator();
        while (iterItem.hasNext()){
            if(!u2.canCarry(iterItem.next())) {
                u2 = new U2();
                u2List.add(u2);
            }
            u2.carry(iterItem.next());
        }
        return u2List;
    }

    public int runSimulation(ArrayList<Rocket> rocketsList){
        int budget = 0;

        ListIterator<Rocket> iterRocket = rocketsList.listIterator();
        while (iterRocket.hasNext()){
            budget += iterRocket.next().cost;
            while(!iterRocket.next().launch() || !iterRocket.next().land()){
                budget += iterRocket.next().cost;
            }
        }
        return budget;
    }
}
