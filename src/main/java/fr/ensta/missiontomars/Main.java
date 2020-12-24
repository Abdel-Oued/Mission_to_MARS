package fr.ensta.missiontomars;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
        ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

        /*-------------------------------------U1------------------------------------------*/

        ArrayList<Rocket> fleetU1 = simulation.loadU1(phase1Items);  // convoit de U1 pour la phase 1
        fleetU1.addAll(simulation.loadU1(phase2Items));              // plus convoit de U1  pour la phase 2

        int budgetU1 = simulation.runSimulation(fleetU1);            // simulation avec la flotte de U1
        System.out.println("Nombre de U1 nécessaires : " + fleetU1.toArray().length + "\nbudgetU1 = " + budgetU1);

        /*-------------------------------------U2------------------------------------------*/

        ArrayList<Rocket> fleetU2 = simulation.loadU2(phase1Items);  // convoit de U2 pour la phase 1
        fleetU2.addAll(simulation.loadU2(phase2Items));              // plus convoit de U2  pour la phase 2

        int budgetU2 = simulation.runSimulation(fleetU2);            // simulation avec la flotte de U2
        System.out.println("Nombre de U2 nécessaires : " + fleetU2.toArray().length + "\nbudgetU2 = " + budgetU2);

    }
}
