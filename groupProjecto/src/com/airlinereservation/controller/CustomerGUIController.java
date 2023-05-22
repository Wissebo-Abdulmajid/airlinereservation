//WISSEBO ABDULMAJID 2218587
package com.airlinereservation.controller;

import com.airlinereservation.Customer;
import com.airlinereservation.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CustomerGUIController {
    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private Button createCustomerButton;

    private Database database;

    public void initialize() {
        database = new Database();
    }

    @FXML
    private void createCustomer() {
        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();

        if (firstName.isEmpty() || lastName.isEmpty()) {
            showErrorMessage("Please enter the customer's first name and last name.");
        } else {
            Customer customer = new Customer(firstName, lastName, lastName, lastName);
            database.addCustomer(customer);

            showSuccessMessage("Customer created successfully.");

            // Clear input fields
            firstNameTextField.clear();
            lastNameTextField.clear();
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
