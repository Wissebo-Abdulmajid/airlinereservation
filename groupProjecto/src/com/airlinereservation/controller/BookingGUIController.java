//WISSEBO ABDULMAJID 2218587
package com.airlinereservation.controller;

import com.airlinereservation.Database;
import com.airlinereservation.Flight;
import com.airlinereservation.Booking;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class BookingGUIController {
    @FXML
    private ChoiceBox<Flight> flightChoiceBox;

    @FXML
    private TextField passengerNameTextField;

    @FXML
    private TextField passengerAgeTextField;

    @FXML
    private Button bookButton;

    private Database database;

    public void initialize() {
        database = new Database();
        flightChoiceBox.setItems(database.getFlights());
    }

    @FXML
    private void bookFlight() {
        Flight selectedFlight = flightChoiceBox.getValue();
        String passengerName = passengerNameTextField.getText();
        String passengerAge = passengerAgeTextField.getText();

        if (selectedFlight == null || passengerName.isEmpty() || passengerAge.isEmpty()) {
            showErrorMessage("Please select a flight and enter passenger details.");
        } else {
            Booking booking = new Booking(selectedFlight, passengerName, Integer.parseInt(passengerAge));
            database.addBooking(booking);

            showSuccessMessage("Booking successful.");

            // Clear input fields
            flightChoiceBox.getSelectionModel().clearSelection();
            passengerNameTextField.clear();
            passengerAgeTextField.clear();
        }
    }

    @FXML
    private void cancelBooking() {
        Booking selectedBooking = getSelectedBooking();
        if (selectedBooking == null) {
            showErrorMessage("Please select a booking to cancel.");
        } else {
            database.removeBooking(selectedBooking);
            showSuccessMessage("Booking canceled successfully.");

            // Refresh the GUI or update the bookings display accordingly
        }
    }

    @FXML
    private void checkAvailability() {
        Flight selectedFlight = flightChoiceBox.getValue();
        if (selectedFlight == null) {
            showErrorMessage("Please select a flight to check availability.");
        } else {
            int availableSeats = selectedFlight.getAvailableSeats();
            showSuccessMessage("Available seats for the selected flight: " + availableSeats);
        }
    }

    private Booking getSelectedBooking() {
        // Implement logic to retrieve the selected booking from the GUI
        // Return the selected Booking object or null if no booking is selected
        return null;
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
