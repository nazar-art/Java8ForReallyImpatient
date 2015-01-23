package com.tasks.capitel3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Generalize Exercise 5 by writing a static method that yields a ColorTransformer
 * that adds a frame of arbitrary thickness and color to an image.
 */
public class C3E8 extends Application {

    public static Image transform(Image in, ColorTransformer t) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                out.getPixelWriter().setColor(x, y,
                        t.apply(x, y, in.getPixelReader().getColor(x, y)));
            }
        }
        return out;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image("images/queen-mary.png");
        Image newImage = transform(image, transformer(image, 20, 5, Color.WHITE));
        stage.setScene(new Scene(new HBox(new ImageView(image), new ImageView(newImage))));
        stage.show();
    }

    public static ColorTransformer transformer(Image image, int argX, int argY, Color argC) {
        return (x, y, c) ->
                (x <= argX || x >= image.getWidth() - argX
                        || y <= argY || y >= image.getHeight() - argY) ? argC : c;

    }

}
