//WISSEBO ABDULMAJID 2218587
package com.airlinereservation.controller;

import com.airlinereservation.Database;
import com.airlinereservation.Flight;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FlightGUIController {
    @FXML
    private TextField flightNumberTextField;

    @FXML
    private TextField destinationTextField;

    @FXML
    private TextField departureTextField;

    @FXML
    private Button createFlightButton;

    private Database database;

    public void initialize() {
        database = new Database();
    }

    @FXML
    private void createFlight() {
        String flightNumber = flightNumberTextField.getText();
        String destination = destinationTextField.getText();
        String departure = departureTextField.getText();

        if (flightNumber.isEmpty() || destination.isEmpty() || departure.isEmpty()) {
            showErrorMessage("Please enter the flight number, destination, and departure.");
        } else {
            Flight flight = new Flight(flightNumber, destination, departure);
            database.addFlight(flight);

            showSuccessMessage("Flight created successfully.");

            // Clear input fields
            flightNumberTextField.clear();
            destinationTextField.clear();
            departureTextField.clear();
        }
    }

    private void showErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void showSuccessMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
