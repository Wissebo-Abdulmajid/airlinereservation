package com.airlinereservation.controller;

import com.airlinereservation.Admin;
import com.airlinereservation.Database;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminGUIController {
    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button createAdminButton;

    private Database database;

    public void initialize() {
        database = new Database();
    }

    @FXML
    private void login() {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (isValidCredentials(username, password)) {
            // Perform login logic, such as navigating to the appropriate dashboard
            showSuccessMessage("Login successful.");

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/airlinereservation/fxml/DashboardGUI.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);

                Stage currentStage = (Stage) usernameTextField.getScene().getWindow();
                currentStage.setScene(scene);
                currentStage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showErrorMessage("Invalid username or password.");
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // Implement your logic to validate the username and password
        // For example, check against a database or predefined credentials
        return username.equals("admin") && password.equals("password");
    }

    @FXML
    private void createAdmin() {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String email = emailTextField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showErrorMessage("Please enter the admin's username and password.");
        } else {
            Admin admin = new Admin(username, email, password);
            database.addAdmin(admin);

            showSuccessMessage("Admin created successfully.");

            // Clear input fields
            usernameTextField.clear();
            passwordTextField.clear();
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
