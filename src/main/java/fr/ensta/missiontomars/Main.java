package fr.ensta.missiontomars;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Choisir une configuration\n" +
                "1 - pour une flotte de rockets U1 uniquement\n" +
                "2 - pour une flotte de rockets U2 uniquement\n" +
                "3 - pour une flotte de rockets U1 pour la phase 1 et U2 pour la phase 2\n" +
                "4 - pour une flotte de rockets U1 pour la phase 2 et U2 pour la phase 1\n" +
                "5 - pour une flotte de rockets U2 pour les personnes\n"
        );

        Scanner sc = new Scanner(System.in);
        int config = sc.nextInt();

        int budgetTotal = 0;
        int budgetMoyen = 0;
        int budgetParfait = 0;
        int nbrSimulation = 1000000;
        int nbrReussite = 0;
        int nbrUnSeulEchec = 0;
        int pourcentageReussite = 0;
        int pourcentageUnSeulEchec = 0;


        Simulation simulation = new Simulation();
        ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
        ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

        if(config == 1) {
            /*-------------------------------------U1------------------------------------------*/

            ArrayList<Rocket> fleetU1 = simulation.loadU1(phase1Items);  // convoit de U1 pour la phase 1
            fleetU1.addAll(simulation.loadU1(phase2Items));              // plus convoit de U1  pour la phase 2

            int i = 1;
            for (Rocket rocket : fleetU1) {
                budgetParfait += rocket.cost;
                System.out.println("U1 " + i + " = " + rocket.currentWeight);
                i++;
            }

            int budget;

            for (i = 0; i<nbrSimulation; i++ ) {
                budget = simulation.runSimulation(fleetU1);            // simulation avec la flotte de U1
                budgetTotal += budget;
                if (budget == budgetParfait){
                    nbrReussite += 1;
                }
                if (budget == budgetParfait + 100){
                    nbrUnSeulEchec += 1;
                }
            }
            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            budgetMoyen = budgetTotal / nbrSimulation;

            System.out.println("Résultats de la simulation\n" +
                    "Pourcentage de réussite : " + pourcentageReussite +
                    "\nPourcentage d'avoir un seul échec : " + pourcentageUnSeulEchec +
                    "\nbudgetMoyen = " + budgetMoyen);
        }

        else if(config == 2) {
            /*-------------------------------------U2------------------------------------------*/

            ArrayList<Rocket> fleetU2 = simulation.loadU2(phase1Items);  // convoit de U2 pour la phase 1
            fleetU2.addAll(simulation.loadU2(phase2Items));              // plus convoit de U2  pour la phase 2

            int i = 1;
            for (Rocket rocket : fleetU2) {
                budgetParfait += rocket.cost;
                System.out.println("U2 " + i + " = " + rocket.currentWeight);
                i++;
            }

            int budget;

            for (i = 0; i<nbrSimulation; i++ ) {
                budget = simulation.runSimulation(fleetU2);            // simulation avec la flotte de U2
                budgetTotal += budget;
                if (budget == budgetParfait){
                    nbrReussite += 1;
                }
                if (budget == budgetParfait + 120){
                    nbrUnSeulEchec += 1;
                }
            }
            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;
            
            budgetMoyen = budgetTotal / nbrSimulation;
            
            System.out.println("Résultats de la simulation\n" +
                    "Pourcentage de réussite : " + pourcentageReussite +
                    "\nPourcentage d'avoir un seul échec : " + pourcentageUnSeulEchec +
                    "\nbudgetMoyen = " + budgetMoyen);
        }

        if(config == 3) {

            ArrayList<Rocket> fleet = simulation.loadU1(phase1Items);  // convoit de U1 pour la phase 1
            fleet.addAll(simulation.loadU2(phase2Items));              // plus convoit de U2  pour la phase 2

            int i = 1;
            for (Rocket rocket : fleet) {
                budgetParfait += rocket.cost;
                if(rocket.cost == 100)
                    System.out.println("U1 " + i + " = " + rocket.currentWeight);
                else
                    System.out.println("U2 " + i + " = " + rocket.currentWeight);
                i++;
            }

            int budget;

            for (i = 0; i<nbrSimulation; i++ ) {
                budget = simulation.runSimulation(fleet);            // simulation avec la flotte mixte
                budgetTotal += budget;
                if (budget == budgetParfait){
                    nbrReussite += 1;
                }
                if (budget == budgetParfait + 100 || budget == budgetParfait + 120){
                    nbrUnSeulEchec += 1;
                }
            }
            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            budgetMoyen = budgetTotal / nbrSimulation;

            System.out.println("Résultats de la simulation\n" +
                    "Pourcentage de réussite : " + pourcentageReussite +
                    "\nPourcentage d'avoir un seul échec : " + pourcentageUnSeulEchec +
                    "\nbudget en cas de réussite = " + budgetParfait +
                    "\nbudget moyen = " + budgetMoyen);
        }

        if(config == 4) {

            ArrayList<Rocket> fleet = simulation.loadU1(phase2Items);  // convoit de U1 pour la phase 2
            fleet.addAll(simulation.loadU2(phase1Items));              // plus convoit de U2  pour la phase 1

            int i = 1;
            for (Rocket rocket : fleet) {
                budgetParfait += rocket.cost;
                if(rocket.cost == 100)
                    System.out.println("U1 " + i + " = " + rocket.currentWeight);
                else
                    System.out.println("U2 " + i + " = " + rocket.currentWeight);
                i++;
            }

            int budget;

            for (i = 0; i<nbrSimulation; i++ ) {
                budget = simulation.runSimulation(fleet);            // simulation avec la flotte mixte
                budgetTotal += budget;
                if (budget == budgetParfait){
                    nbrReussite += 1;
                }
                if (budget == budgetParfait + 100 || budget == budgetParfait + 120){
                    nbrUnSeulEchec += 1;
                }
            }
            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            budgetMoyen = budgetTotal / nbrSimulation;

            System.out.println("Résultats de la simulation\n" +
                    "Pourcentage de réussite : " + pourcentageReussite +
                    "\nPourcentage d'avoir un seul échec : " + pourcentageUnSeulEchec +
                    "\nbudget en cas de réussite = " + budgetParfait +
                    "\nbudgetMoyen = " + budgetMoyen);
        }

        if(config == 5) {

            ArrayList<Rocket> fleet = simulation.load(phase1Items);  // convoit de U1 pour la phase 1
            fleet.addAll(simulation.load(phase2Items));              // plus convoit de U2  pour la phase 2

            int i = 1;
            for (Rocket rocket : fleet) {
                budgetParfait += rocket.cost;
                if(rocket.cost == 100)
                    System.out.println("U1 " + i + " = " + rocket.currentWeight);
                else
                    System.out.println("U2 " + i + " = " + rocket.currentWeight);
                i++;
            }

            int budget;

            for (i = 0; i<nbrSimulation; i++ ) {
                budget = simulation.runSimulation(fleet);            // simulation avec la flotte mixte
                budgetTotal += budget;
                if (budget == budgetParfait){
                    nbrReussite += 1;
                }
                if (budget == budgetParfait + 100 || budget == budgetParfait + 120){
                    nbrUnSeulEchec += 1;
                }
            }
            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            budgetMoyen = budgetTotal / nbrSimulation;

            System.out.println("Résultats de la simulation\n" +
                    "Pourcentage de réussite : " + pourcentageReussite +
                    "\nPourcentage d'avoir un seul échec : " + pourcentageUnSeulEchec +
                    "\nbudget en cas de réussite = " + budgetParfait +
                    "\nbudget moyen = " + budgetMoyen);
        }
    }
}
