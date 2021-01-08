package fr.ensta.missiontomars;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe principale.
 * Point d'entree de l'application.
 */
public class Main extends Application {
    static int budgetParfait = 0;
    static int budget = 0;
    static int nbrSimulation = 1000000;
    static int nbrReussite = 0;
    static int nbrUnSeulEchec = 0;
    static int pourcentageReussite = 0;
    static int pourcentageUnSeulEchec = 0;
    static int config = 6;
    static ArrayList<Rocket> fleet;

    @FXML private Label welcome;
    @FXML private Label resultTitle;
    @FXML private ScrollPane results;
    @FXML private Label resultText;
    @FXML private Label fleetText;
    @FXML private Button runButton;
    @FXML private ImageView img;

    Simulation simulation = new Simulation();

    /**
     * Methode principale de l'interface.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("main.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        root.setStyle("-fx-background-color: white");
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Mission To Mars");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Methode qui s'execute lorsqu'on choisi le scenario 1.
     ** @param event signale un clic.
     */
    @FXML protected void handleConfig1(ActionEvent event) {
        config = 1;
        welcome.setVisible(false);
        resultTitle.setVisible(false);
        resultText.setVisible(false);
        fleetText.setVisible(false);
        runButton.setVisible(true);
    }

    /**
     * Methode qui s'execute lorsqu'on choisi le scenario 2.
     * @param event signale un clic.
     */
    @FXML protected void handleConfig2(ActionEvent event){
        config = 2;
        welcome.setVisible(false);
        resultTitle.setVisible(false);
        resultText.setVisible(false);
        fleetText.setVisible(false);
        runButton.setVisible(true);
    }

    /**
     * Methode qui s'execute lorsqu'on choisi le scenario 3.
     * @param event signale un clic.
     */
    @FXML protected void handleConfig3(ActionEvent event){
        config = 3;
        welcome.setVisible(false);
        resultTitle.setVisible(false);
        resultText.setVisible(false);
        fleetText.setVisible(false);
        runButton.setVisible(true);
    }

    /**
     * Methode qui s'execute lorsqu'on choisi le scenario 4.
     * @param event signale un clic.
     */
    @FXML protected void handleConfig4(ActionEvent event){
        config = 4;
        welcome.setVisible(false);
        resultTitle.setVisible(false);
        resultText.setVisible(false);
        fleetText.setVisible(false);
        runButton.setVisible(true);
    }

    /**
     * Methode qui s'execute lorsqu'on choisi le scenario 5
     * @param event signale un clic.
     */
    @FXML protected void handleConfig5(ActionEvent event){
        config = 5;
        welcome.setVisible(false);
        resultTitle.setVisible(false);
        resultText.setVisible(false);
        fleetText.setVisible(false);
        runButton.setVisible(true);
    }

    /**
     * Methode qui s'execute lorsqu'on choisi le scenario 6
     * @param event signale un clic.
     */
    @FXML protected void handleConfig6(ActionEvent event){
        config = 6;
        welcome.setVisible(false);
        resultTitle.setVisible(false);
        resultText.setVisible(false);
        fleetText.setVisible(false);
        runButton.setVisible(true);
    }

    /**
     * Methode qui effectue la simulation en fonction du scenario choisi.
     * Elle cree les listes d'items, cree le convoie de rockets.
     *  @param event signale un clic.
     */
    @FXML protected void runScenario(ActionEvent event){

        welcome.setVisible(false);
        resultTitle.setVisible(false);
        resultText.setVisible(false);
        fleetText.setVisible(false);
        runButton.setVisible(false);

        if(config == 1) {
            /*-------------------------------------U1------------------------------------------*/
            ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
            ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

            ArrayList<Rocket> fleet = simulation.loadU1(phase1Items);  // convoit de U1 pour la phase 1
            fleet.addAll(simulation.loadU1(phase2Items));              // plus convoit de U1  pour la phase 2

            displayFleet(fleet);

            computeResults(simulation, fleet);

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

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);
        }

        else if(config == 3) {
            ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
            ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

            ArrayList<Rocket> fleet = simulation.loadU1(phase1Items);  // convoit de U1 pour la phase 1
            fleet.addAll(simulation.loadU2(phase2Items));              // plus convoit de U2  pour la phase 2

            displayFleet(fleet);

            computeResults(simulation, fleet);

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);
        }

        else if(config == 4) {
            ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
            ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

            ArrayList<Rocket> fleet = simulation.loadU1(phase2Items);  // convoit de U1 pour la phase 2
            fleet.addAll(simulation.loadU2(phase1Items));              // plus convoit de U2  pour la phase 1

            displayFleet(fleet);

            computeResults(simulation, fleet);

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);
        }

        else if(config == 5) {
            ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
            ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

            ArrayList<Rocket> fleet = simulation.load(phase1Items);
            fleet.addAll(simulation.load(phase2Items));

            displayFleet(fleet);

            computeResults(simulation, fleet);

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);

        }

        else if(config == 6) {
            ArrayList<Item> phase1Items = simulation.loadItems("Phase-1.txt");
            ArrayList<Item> phase2Items = simulation.loadItems("Phase-2.txt");

            ArrayList<Rocket> fleet = simulation.loadU2Optimum(phase1Items);
            fleet.addAll(simulation.loadU2Optimum(phase2Items));

            displayFleet(fleet);

            computeResults(simulation, fleet);

            displayResults(pourcentageReussite, pourcentageUnSeulEchec, budgetParfait);
        }
    }

    /**d
     * Methode qui fait les appels à runSimulation puis calcules staistiques
     * @param simulation instance de Simulation
     * @param fleet la flotte de rockets de la mission
     */
    public void computeResults(Simulation simulation, ArrayList<Rocket> fleet){
        nbrReussite = 0;
        nbrUnSeulEchec = 0;
        for (int i = 0; i<nbrSimulation; i++ ) {
            budget = simulation.runSimulation(fleet);            // simulation avec la flotte
            if (budget == budgetParfait){
                nbrReussite += 1;
            }

            // s'il y a un seul echec
            if (budget == budgetParfait + 100 || budget == budgetParfait + 120){
                nbrUnSeulEchec += 1;
            }
        }
        pourcentageReussite = nbrReussite*100/nbrSimulation;
        pourcentageUnSeulEchec = nbrUnSeulEchec*100/nbrSimulation;

    }

    /**
     * Methode qui affiche les resultats de la simulation
     * @param pourcentageReussite
     * @param pourcentageUnSeulEchec pourcentage qu'il ait un seul echec
     * @param budgetParfait budget s'il n'y a aucun echec
     */
    public void displayResults(int pourcentageReussite, int pourcentageUnSeulEchec, int budgetParfait){
        resultTitle.setVisible(true);
        resultText.setText(
                "\nPourcentage de reussite : " + pourcentageReussite +
                "\nPourcentage d'avoir un seul echec : " + pourcentageUnSeulEchec +
                "\nbudget en cas de reussite = " + budgetParfait);
        resultText.setVisible(true);
        runButton.setVisible(false);
        img.setTranslateY(0);
    }

    /**
     * Methode qui affiche les rockets et leur poids
     * @param fleet flotte de rockets de la mission
     */
    public void displayFleet(ArrayList<Rocket> fleet){
        int i = 1;
        budgetParfait = 0;
        StringBuilder fleetTotal = new StringBuilder();
        fleetTotal = fleetTotal.append("Convoit de rockets\n\n");
        for (Rocket rocket : fleet) {
            budgetParfait += rocket.cost;    // c'est le budget s'il n'y a aucune explosion
            if(rocket.cost == 100)
                fleetTotal = fleetTotal.append("U1 " + i + " = " + rocket.currentWeight + "\t\t");
            else
                fleetTotal = fleetTotal.append("U2 " + i + " = " + rocket.currentWeight + "\t\t");

            if(i%2 ==0) fleetTotal = fleetTotal.append("\n");

            i++;
        }
        fleetText.setVisible(true);
        fleetText.setText(String.valueOf(fleetTotal));
    }

}