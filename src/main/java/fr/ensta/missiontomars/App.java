package fr.ensta.missiontomars;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Hello world!
 */
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("App !");
        primaryStage.setScene(new Scene(new App.AppPane(), 200, 100));
        primaryStage.show();
    }

    static class AppPane extends BorderPane {
        private int nbClick = 0;

        AppPane() {
            Button buttonClick = new Button("Click !");
            buttonClick.setId("buttonClick");
            buttonClick.setOnAction(event -> buttonClick.setText(String.valueOf(++nbClick)));
            this.setCenter(buttonClick);
        }
    }
}