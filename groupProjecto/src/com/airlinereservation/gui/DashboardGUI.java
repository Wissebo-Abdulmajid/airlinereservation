//WISSEBO ABDULMAJID 221857
package com.airlinereservation.gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardGUI {

    public void display() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/com/airlinereservation/fxml/DashboardGUI.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Airline Reservation System - Dashboard");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
