package com.tasks.capitel4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Find out how to set the border of a control without using CSS.
 */
public class C4E7 extends Application {

    public void start(Stage stage) {
        BorderPane pane = new BorderPane();
        Label label = new Label("This is a Test");
        label.setBorder(new Border(
                new BorderStroke(
                        Color.web("0xd62645"),
                        BorderStrokeStyle.SOLID,
                        null,
                        new BorderWidths(4))));
        pane.setCenter(label);
        stage.setScene(new Scene(pane));
        stage.show();
    }

}
