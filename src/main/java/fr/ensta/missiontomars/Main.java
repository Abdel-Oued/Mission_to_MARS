package fr.ensta.missiontomars;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();
        ArrayList<Item> phase1Items = simulation.loadItems("Phase-1");
        ArrayList<Item> phase2Items = simulation.loadItems("Phase-2");

        ArrayList<Rocket> fleetU1 = simulation.loadU1(phase1Items);
        fleetU1.addAll(simulation.loadU1(phase2Items));

        int budgetU1 = simulation.runSimulation(fleetU1);
        System.out.println("budgetU1 = " + budgetU1);

        ArrayList<Rocket> fleetU2 = simulation.loadU2(phase1Items);
        fleetU2.addAll(simulation.loadU2(phase2Items));

        int budgetU2 = simulation.runSimulation(fleetU2);
        System.out.println("budgetU2 = " + budgetU2);

    }
}
