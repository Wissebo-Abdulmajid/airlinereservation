//WISSEBO ABDULMAJID 2218587
package com.airlinereservation.controller;

import com.airlinereservation.Database;
import com.airlinereservation.Booking;
import com.airlinereservation.Cancellation;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;

public class CancellationGUIController {
    @FXML
    private ChoiceBox<Booking> bookingChoiceBox;

    @FXML
    private Button cancelButton;

    private Database database;

    public void initialize() {
        database = new Database();
        bookingChoiceBox.setItems((ObservableList<Booking>) database.getAllBookings());
    }

    @FXML
    private void cancelBooking() {
        Booking selectedBooking = bookingChoiceBox.getValue();
        if (selectedBooking == null) {
            showErrorMessage("Please select a booking to cancel.");
        } else {
            Cancellation cancellation = new Cancellation(selectedBooking, "Cancellation reason"); // Replace "Cancellation reason" with the actual reason entered by the user
            database.addCancellation(cancellation);
            database.removeBooking(selectedBooking);

            showSuccessMessage("Booking canceled successfully.");

            // Refresh the GUI or update the bookings display accordingly
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
