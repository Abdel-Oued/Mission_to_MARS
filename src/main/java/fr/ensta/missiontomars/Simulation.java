package fr.ensta.missiontomars;

import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Classe de création de simulation
 */
public class Simulation {

    /**
     * Méthode qui charge tous les items à partir d'un fichier texte
     * @param filename nom du fichier texte
     * @return itemsList liste contenant les items
     */
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

    /**
     * Méthode qui crée des rockets U1 et les charges avec les items d'une liste d'items
     * @param itemsList liste des items
     * @return u1List liste des rockets U1 créées et chargées
     */
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

    /**
     * Méthode qui crée des rockets U2 et les charges avec les items d'une liste d'items
     * @param itemsList liste des items
     * @return u1List liste des rockets U2 créées et chargées
     */
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

    /**
     * Méthode qui crée des rockets U1 et U2 et les charges avec les items d'une liste d'items.
     * Le chargement est fait de sorte qu'aucune rocket U1 ne soit pleine.
     * Les rockets U2 sont employées pour les personnes et les charges lourdes.
     * De plus, une rocket transportant des personnes ne transporte que des personnes.
     * @param itemsList liste des items
     * @return u1List liste des rockets U2 crées et chargées
     */
    public ArrayList<Rocket> load(ArrayList<Item> itemsList){
        ArrayList<Rocket> rocketList = new ArrayList<>();
        Rocket rocket1 = new U1();
        Rocket rocket2;
        rocketList.add(rocket1);

        for (Item item : itemsList){
            if(item.getName().equals("colony")){
                rocket2 = new U2();
                rocket2.carry(item);
                rocketList.add(rocket2);
            }
            else if(rocket1.currentWeight + item.getWeight() > rocket1.maxWeight - 3) {
                if (item.getWeight() > 6) {
                    rocket2 = new U2();
                    rocket2.carry(item);
                    rocketList.add(rocket2);
                }
                else {
                    rocket1 = new U1();
                    rocket1.carry(item);
                    rocketList.add(rocket1);
                }

            }

            else rocket1.carry(item);
        }
        return rocketList;
    }

    /**
     * Méthode qui crée des rockets U2 et les charges avec les items d'une liste d'items.
     * Le chargement est fait de sorte qu'aucune rocket ne soit pleine.
     * De plus, une rocket transportant des personnes ne transporte que des personnes.
     * @param itemsList liste des items
     * @return u1List liste des rockets U2 crées et chargées
     */
    public ArrayList<Rocket> loadU2Optimum(ArrayList<Item> itemsList){
        ArrayList<Rocket> rocketList = new ArrayList<>();
        ArrayList<Item> itemsCarried;  // stocke les items transportés après chaque itération

        // on reitère jusqu'à ce que la liste d'items soit vide
        while(!itemsList.isEmpty()) {
            itemsCarried = new ArrayList<>();
            Rocket rocket = new U2();
            rocketList.add(rocket);

            // parcourir la liste d'items non encore transportés
            for (Item item : itemsList){
                // si la rocket prend l'item, son poids va dépasser un seuil,
                // dans ce cas, essayer l'item suivant en quittant la boucle for
                if(rocket.currentWeight + item.getWeight() > rocket.maxWeight - 3) {
                    continue;
                }

                // si on tombe sur des personnes et que la rocket est vide,
                // alors on les transporte et qui la boucle while pour créer
                // une autre rocket
                if(item.getName().equals("colony") & rocket.currentWeight == rocket.weight){
                    rocket.carry(item);
                    itemsCarried.add(item);
                    break;
                }

                else {
                    rocket.carry(item);
                    itemsCarried.add(item);
                }
            }

            // supprimer les items transportés de la liste d'items
            for(Item item : itemsCarried){
                System.out.println(itemsCarried.size());
                itemsList.remove(item);
            }
        }
        return rocketList;

    }

    /**
     * Méthode qui tente de lancer chaque rocket présente dans une liste de rockets jusqu'à ce que le lancement réussisse.
     * @param rocketsList liste des rockets à lancer
     * @return budget budget total pour envoyer toutes les rockets (inclut les crashs et explosions)
     */
    public int runSimulation(ArrayList<Rocket> rocketsList){
        int budget = 0;

        for (Rocket rocket : rocketsList){
            budget += rocket.cost;
            // si le lancement n'a pas réussi, inutile de tester si l'atterrissage va réussir
            // on relance direct
            while(!rocket.launch() || !rocket.land()){
                budget += rocket.cost;
            }
        }
        return budget;
    }
}
