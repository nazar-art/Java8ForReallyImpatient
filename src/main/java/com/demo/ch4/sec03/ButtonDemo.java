package com.demo.ch4.sec03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ButtonDemo extends Application {
    public void start(Stage stage) {
        Label message = new Label("Hello, JavaFX!");
        message.setFont(new Font(100));
        Button red = new Button("Red");
        red.setOnAction(event -> message.setTextFill(Color.RED));

        Button black = new Button("Black");
        black.setOnAction(event -> message.setTextFill(Color.BLACK));

        VBox root = new VBox();
        root.getChildren().addAll(red, black, message);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

