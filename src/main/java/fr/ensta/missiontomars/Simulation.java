package fr.ensta.missiontomars;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class Simulation {

    public ArrayList<Item> loadItems(String filename) {
        ArrayList<Item> itemsList = new ArrayList<>();
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

        for (Item item : itemsList){
            if(!u1.canCarry(item)) {
                u1 = new U1();
                u1List.add(u1);
            }
            u1.carry(item);
        }
        return u1List;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemsList){
        ArrayList<Rocket> u2List = new ArrayList<>();
        U2 u2 = new U2();
        u2List.add(u2);

        for (Item item : itemsList){
            if(!u2.canCarry(item)) {
                u2 = new U2();
                u2List.add(u2);
            }
            u2.carry(item);
        }
        return u2List;
    }

    public ArrayList<Rocket> load(ArrayList<Item> itemsList){
        ArrayList<Rocket> rocketList = new ArrayList<>();
        Rocket rocket = new U1();
        rocketList.add(rocket);

        for (Item item : itemsList){
            if(rocket.currentWeight + item.getWeight() > rocket.maxWeight - 4) {
                if (item.getWeight() > 4)
                    rocket = new U2();
                else
                    rocket = new U1();
                rocketList.add(rocket);
            }
            if(item.getName().equals("colony")){
                rocket = new U2();
                rocketList.add(rocket);
            }
            rocket.carry(item);
        }
        return rocketList;
    }

    public int runSimulation(ArrayList<Rocket> rocketsList){
        int budget = 0;

        for (Rocket rocket : rocketsList){
            budget += rocket.cost;
            while(!rocket.launch() || !rocket.land()){
                budget += rocket.cost;
            }
        }
        return budget;
    }
}
