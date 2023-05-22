package com.airlinereservation.controller;

import com.airlinereservation.Customer;
import com.airlinereservation.Flight;
import com.airlinereservation.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;

import java.util.List;

public class DashboardGUIController {

    private static final double DEFAULT_PRICE = 0.0;

    @FXML
    private Label welcomeLabel;

    @FXML
    private TextField flightNumberTextField;

    @FXML
    private TextField flightDestinationTextField;

    @FXML
    private TextField flightDepartureTextField;

    @FXML
    private Button addFlightButton;

    @FXML
    private Button deleteFlightButton;

    @FXML
    private Button viewCustomersButton;

    @FXML
    private TableView<Flight> flightsTableView;

    private String username;
    private Database database;

    public void setUsername(String username) {
        this.username = username;
        welcomeLabel.setText("Welcome, " + username + "!");
        database = Database.getInstance(); // Assuming Database class follows the singleton pattern
    }

    @FXML
    private void addFlight() {
        String flightNumber = flightNumberTextField.getText();
        String destination = flightDestinationTextField.getText();
        String departure = flightDepartureTextField.getText();

        if (flightNumber.isEmpty() || destination.isEmpty() || departure.isEmpty()) {
            showErrorMessage("Please enter the flight details.");
        } else {
            Flight flight = new Flight(flightNumber, "", "", departure, destination, departure, DEFAULT_PRICE);
            database.addFlight(flight);
            showSuccessMessage("Flight added successfully.");

            // Refresh GUI
            refreshFlights();

            // Clear input fields
            flightNumberTextField.clear();
            flightDestinationTextField.clear();
            flightDepartureTextField.clear();
        }
    }

    @FXML
    private void deleteFlight() {
        String flightNumber = flightNumberTextField.getText();

        if (flightNumber.isEmpty()) {
            showErrorMessage("Please enter the flight number.");
        } else {
            Flight flight = database.getFlight(flightNumber);
            if (flight != null) {
                database.removeFlight(flight);
                showSuccessMessage("Flight deleted successfully.");

                // Refresh GUI
                refreshFlights();
            } else {
                showErrorMessage("Flight not found.");
            }

            // Clear input field
            flightNumberTextField.clear();
        }
    }

    @FXML
    private void viewCustomers() {
        StringBuilder customers = new StringBuilder();
        List<Customer> customerList = database.getAllCustomers();
        if (customerList.isEmpty()) {
            showInformationMessage("No customers found.");
        } else {
            for (Customer customer : customerList) {
                customers.append(customer.getFirstName()).append("\n");
            }
            showInformationMessage(customers.toString());
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

    private void showInformationMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void refreshFlights() {
        List<Flight> flights = database.getAllFlights();
        flightsTableView.getItems().setAll(flights);
    }
}
