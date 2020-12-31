package fr.ensta.missiontomars;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Hello world!
 */
public class App extends Application {
    static int budgetParfait = 0;
    static int budget = 0;
    static int nbrSimulation = 1000000;
    static int nbrReussite = 0;
    static int nbrUnSeulEchec = 0;
    static int pourcentageReussite = 0;
    static int pourcentageUnSeulEchec = 0;
    static ArrayList<Rocket> fleet;

    @FXML private Text actiontarget;
    @FXML private Label resultText;
    Parent root = null;
    Stage stage = new Stage();
    Scene scene;

    Simulation simulation = new Simulation();
//    ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
//    ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        root.setStyle("-fx-background-color: white");
        this.stage = primaryStage;
        scene = new Scene(root, 800, 600);
//        primaryStage.setTitle("Mission To Mars");
//        primaryStage.setScene(scene);
//        primaryStage.show();
        stage.setTitle("Mission To Mars");
        stage.setScene(scene);
        stage.show();
    }

    @FXML protected void handleConfig1(ActionEvent event){
        actiontarget.setText("Sign in button pressed");
        try {
            root = FXMLLoader.load(getClass().getResource("app.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        scene = new Scene(root,200, 100);
//        this.stage.setScene(scene);
//        this.stage.show();

        //resultText.setText(String.valueOf(getClass().getResource("app.fxml")));
        runWithConfig(1);
    }

    @FXML protected void handleConfig2(ActionEvent event){
        runWithConfig(2);
    }

    @FXML protected void handleConfig3(ActionEvent event){
        runWithConfig(3);
    }

    @FXML protected void handleConfig4(ActionEvent event){
        runWithConfig(4);
    }

    @FXML protected void handleConfig5(ActionEvent event){
        runWithConfig(6);
    }

    public void runWithConfig(int config){
        if(config == 1) {
            /*-------------------------------------U1------------------------------------------*/
            ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
            ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

            ArrayList<Rocket> fleet = simulation.loadU1(phase1Items);  // convoit de U1 pour la phase 1
            fleet.addAll(simulation.loadU1(phase2Items));              // plus convoit de U1  pour la phase 2

            displayFleet(fleet);

            computeResults(simulation, fleet);

            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);


        }

        else if(config == 2) {
            /*-------------------------------------U2------------------------------------------*/
            ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
            ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

            ArrayList<Rocket> fleet = simulation.loadU2(phase1Items);  // convoit de U2 pour la phase 1
            fleet.addAll(simulation.loadU2(phase2Items));              // plus convoit de U2  pour la phase 2

            displayFleet(fleet);

            computeResults(simulation, fleet);

            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);
        }

        else if(config == 3) {
            ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
            ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

            ArrayList<Rocket> fleet = simulation.loadU1(phase1Items);  // convoit de U1 pour la phase 1
            fleet.addAll(simulation.loadU2(phase2Items));              // plus convoit de U2  pour la phase 2

            displayFleet(fleet);

            computeResults(simulation, fleet);

            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);
        }

        else if(config == 4) {
            ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
            ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

            ArrayList<Rocket> fleet = simulation.loadU1(phase2Items);  // convoit de U1 pour la phase 2
            fleet.addAll(simulation.loadU2(phase1Items));              // plus convoit de U2  pour la phase 1

            displayFleet(fleet);

            computeResults(simulation, fleet);

            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);
        }

        else if(config == 5) {
            ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
            ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

            ArrayList<Rocket> fleet = simulation.load(phase1Items);
            fleet.addAll(simulation.load(phase2Items));

            displayFleet(fleet);

            computeResults(simulation, fleet);

            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);

        }

        else if(config == 6) {
            ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
            ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

            ArrayList<Rocket> fleet = simulation.load2(phase1Items);
            fleet.addAll(simulation.load2(phase2Items));

            displayFleet(fleet);

            computeResults(simulation, fleet);

            pourcentageReussite = nbrReussite*100/nbrSimulation;
            pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);
        }
    }

    public void computeResults(Simulation simulation, ArrayList<Rocket> fleet){
        nbrReussite = 0;
        nbrUnSeulEchec = 0;
        for (int i = 0; i<nbrSimulation; i++ ) {
            budget = simulation.runSimulation(fleet);            // simulation avec la flotte
            if (budget == budgetParfait){
                nbrReussite += 1;
            }
            if (budget == budgetParfait + 100 || budget == budgetParfait + 120){
                nbrUnSeulEchec += 1;
            }
        }
    }

    public void displayResults2(int pourcentageReussite, int pourcentageUnSeulEchec, int budgetParfait){
        System.out.println("Résultats de la simulation\n" +
                "Pourcentage de réussite : " + pourcentageReussite +
                "\nPourcentage d'avoir un seul échec : " + pourcentageUnSeulEchec +
                "\nbudget en cas de réussite = " + budgetParfait);
    }

    public void displayResults(int pourcentageReussite, int pourcentageUnSeulEchec, int budgetParfait){
        resultText.setText("Resultats de la simulation\n" +
                "Avec cette configuration on obtient les estimations suivantes" +
                "Pourcentage de reussite : " + pourcentageReussite +
                "\nPourcentage d'avoir un seul echec : " + pourcentageUnSeulEchec +
                "\nbudget en cas de reussite = " + budgetParfait);

    }

    public void displayFleet(ArrayList<Rocket> fleet){
        int i = 1;
        budgetParfait = 0;
        for (Rocket rocket : fleet) {
            budgetParfait += rocket.cost;    // c'est le budget s'il n'y a aucune explosion
            if(rocket.cost == 100)
                System.out.println("U1 " + i + " = " + rocket.currentWeight);
            else
                System.out.println("U2 " + i + " = " + rocket.currentWeight);
            i++;
        }
    }

}