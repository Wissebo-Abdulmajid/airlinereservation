//WISSEBO ABDULMAJID 2218587
package com.airlinereservation.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CancellationGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/airlinereservation/fxml/CancellationGUI.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Cancellation Operations");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
