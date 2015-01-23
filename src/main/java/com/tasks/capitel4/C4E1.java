package com.tasks.capitel4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Write a program with a text field and a label. As with the Hello, JavaFX program,
 * the label should have the string Hello, FX in a 100 point font. Initialize
 * the text field with the same string. Update the label as the user edits the text
 * field.
 */
public class C4E1 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox vBox = new VBox();
        Label message = new Label();
        message.setFont(new Font(100));
        TextField textField = new TextField("Hello, JavaFX!");
        message.textProperty().bind(textField.textProperty());
        vBox.getChildren().addAll(message, textField);
        stage.setScene(new Scene(vBox));
        stage.setTitle("Hello");
        stage.show();
    }
}
