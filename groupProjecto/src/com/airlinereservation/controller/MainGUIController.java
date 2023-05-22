package com.airlinereservation.controller;

import com.airlinereservation.gui.AdminGUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class MainGUIController {
    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button loginButton;

    @FXML
    private void login() {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (isValidCredentials(username, password)) {
            // Perform login logic, such as navigating to the appropriate dashboard
            showSuccessMessage("Login successful.");
            navigateToAdminGUI();
        } else {
            showErrorMessage("Invalid username or password.");
        }
    }

    private boolean isValidCredentials(String username, String password) {
        // Implement your logic to validate the username and password
        // For example, check against a database or predefined credentials
        return username.equals("admin") && password.equals("password");
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

    private void navigateToAdminGUI() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/airlinereservation/fxml/AdminGUI.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Admin Dashboard");
            stage.setScene(scene);
            stage.show();

            // Close the current login window
            Stage loginStage = (Stage) loginButton.getScene().getWindow();
            loginStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
