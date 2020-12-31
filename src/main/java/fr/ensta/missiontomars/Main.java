package fr.ensta.missiontomars;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int budgetParfait = 0;
    static int budget = 0;
    static int nbrSimulation = 1000000;
    static int nbrReussite = 0;
    static int nbrUnSeulEchec = 0;
    static int pourcentageReussite = 0;
    static int pourcentageUnSeulEchec = 0;

    public static void main(String[] args) {

        System.out.println("Choisir une configuration\n" +
                "1 - pour une flotte de rockets U1 uniquement\n" +
                "2 - pour une flotte de rockets U2 uniquement\n" +
                "3 - pour une flotte de rockets U1 pour la phase 1 et U2 pour la phase 2\n" +
                "4 - pour une flotte de rockets U1 pour la phase 2 et U2 pour la phase 1\n" +
                "5 - pour une flotte de rockets U2 pour les personnes\n" +
                "6 - pour une flotte de rockets U2 pour les personnes optimisée\n"
        );

        Scanner sc = new Scanner(System.in);
        int config = sc.nextInt();

        Simulation simulation = new Simulation();
        ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
        ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

        if(config == 1) {
            /*-------------------------------------U1------------------------------------------*/

            ArrayList<Rocket> fleet = simulation.loadU1(phase1Items);  // convoit de U1 pour la phase 1
            fleet.addAll(simulation.loadU1(phase2Items));              // plus convoit de U1  pour la phase 2

            displayFleet(fleet);

            computeResults(simulation, fleet);

            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);

        }

        else if(config == 2) {
            /*-------------------------------------U2------------------------------------------*/

            ArrayList<Rocket> fleet = simulation.loadU2(phase1Items);  // convoit de U2 pour la phase 1
            fleet.addAll(simulation.loadU2(phase2Items));              // plus convoit de U2  pour la phase 2

            displayFleet(fleet);

            computeResults(simulation, fleet);

            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);
        }

        else if(config == 3) {

            ArrayList<Rocket> fleet = simulation.loadU1(phase1Items);  // convoit de U1 pour la phase 1
            fleet.addAll(simulation.loadU2(phase2Items));              // plus convoit de U2  pour la phase 2

            displayFleet(fleet);

            computeResults(simulation, fleet);

            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);
        }

        else if(config == 4) {

            ArrayList<Rocket> fleet = simulation.loadU1(phase2Items);  // convoit de U1 pour la phase 2
            fleet.addAll(simulation.loadU2(phase1Items));              // plus convoit de U2  pour la phase 1

            displayFleet(fleet);

            computeResults(simulation, fleet);

            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);
        }

        else if(config == 5) {

            ArrayList<Rocket> fleet = simulation.load(phase1Items);
            fleet.addAll(simulation.load(phase2Items));

            displayFleet(fleet);

            computeResults(simulation, fleet);

            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);

        }

        else if(config == 6) {

            ArrayList<Rocket> fleet = simulation.load2(phase1Items);
            fleet.addAll(simulation.load2(phase2Items));

            displayFleet(fleet);

            computeResults(simulation, fleet);

            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);
        }
    }

    public static void computeResults(Simulation simulation, ArrayList<Rocket> fleet){
        for (int i = 0; i<nbrSimulation; i++ ) {
            budget = simulation.runSimulation(fleet);            // simulation avec la flotte mixte
            if (budget == budgetParfait){
                nbrReussite += 1;
            }
            if (budget == budgetParfait + 100 || budget == budgetParfait + 120){
                nbrUnSeulEchec += 1;
            }
        }
    }

    public static void displayResults(int pourcentageReussite, int pourcentageUnSeulEchec, int budgetParfait){
        System.out.println("Résultats de la simulation\n" +
                "Pourcentage de réussite : " + pourcentageReussite +
                "\nPourcentage d'avoir un seul échec : " + pourcentageUnSeulEchec +
                "\nbudget en cas de réussite = " + budgetParfait);
    }

    public static void displayFleet(ArrayList<Rocket> fleet){
        int i = 1;
        for (Rocket rocket : fleet) {
            budgetParfait += rocket.cost;
            if(rocket.cost == 100)
                System.out.println("U1 " + i + " = " + rocket.currentWeight);
            else
                System.out.println("U2 " + i + " = " + rocket.currentWeight);
            i++;
        }
    }
}
