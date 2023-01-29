package com.example.loginForm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Controller {

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField usernameTextUsername;
    @FXML
    private PasswordField passwordPasswordField;

    public void loginButtonOnAction(ActionEvent e) {
        if(!usernameTextUsername.getText().isBlank() && !passwordPasswordField.getText().isBlank()){
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password.");
        }
    }
    public void cancelButtonOnAction(ActionEvent e) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connection = databaseConnection.getConnection();
        String verifyLogin = "SELECT count(1) from USERACCOUNTS WHERE USERNAME ='" + usernameTextUsername.getText() + "' and password = '" + passwordPasswordField.getText() + "'";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select count(1) from USERACCOUNTS where USERNAME=? and password=?");
            preparedStatement.setString(1, usernameTextUsername.getText());
            preparedStatement.setString(2, passwordPasswordField.getText());
            ResultSet queryResult = preparedStatement.executeQuery();
            while(queryResult.next()){
                if(queryResult.getInt(1) == 1){
                    loginMessageLabel.setText("Login succesfull!");
                    loginMessageLabel.setStyle("-fx-text-fill: green;");
                }else {
                    loginMessageLabel.setText("Invalid login... Please try again!");
                    loginMessageLabel.setStyle("-fx-text-fill: red;");
                }
            }
        } catch (Exception e) {
            System.out.println("e.getLocalizedMessage() = " + e.getLocalizedMessage());
        }
    }
}