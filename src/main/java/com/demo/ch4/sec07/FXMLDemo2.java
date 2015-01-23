package com.demo.ch4.sec07;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class FXMLDemo2 extends Application {
    public void start(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/dialog2.fxml"));

            TextField username = (TextField) root.lookup("#username");
            PasswordField password = (PasswordField) root.lookup("#password");
            Button okButton = (Button) root.lookup("#ok");
            okButton.disableProperty().bind(
                    Bindings.createBooleanBinding(
                            () -> username.getText().length() == 0
                                    || password.getText().length() == 0,
                            username.textProperty(),
                            password.textProperty()));

         /*
         okButton.disableProperty().bind(
            Bindings.or(Bindings.isEmpty(username.textProperty()),
               Bindings.isEmpty(password.textProperty())));
               // Didn't work with static import
         */

            okButton.setOnAction(event ->
                    System.out.println("Verifying " + username.getText() + ":" + password.getText()));

            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(0);
        }
    }
}

