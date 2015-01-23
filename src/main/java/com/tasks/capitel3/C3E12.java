package com.tasks.capitel3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

/**
 * Enhance the LatentImage class in Section 3.6, “Laziness,” on page 56, so that it
 * supports both UnaryOperator<Color> and ColorTransformer. Hint: Adapt the former
 * to the latter.
 */
public class C3E12 extends Application {

    public void start(Stage stage) {
        Image image = new Image("images/queen-mary.png");
        Image finalImage = LatentImage.from(image)
                .transform(Color::brighter)
                .transform(Color::grayscale)
                .transform((x, y, c) -> (
                        x <= 5 || x >= image.getWidth() - 5
                                || y <= 5 || y >= image.getHeight() - 5) ? Color.WHITE : c)
                .toImage();
        stage.setScene(new Scene(new HBox(
                new ImageView(image),
                new ImageView(finalImage))));
        stage.show();
    }

}

class LatentImage {
    private Image in;
    private List<ColorTransformer> pendingOperations;

    public static LatentImage from(Image in) {
        LatentImage result = new LatentImage();
        result.in = in;
        result.pendingOperations = new ArrayList<>();
        return result;
    }

    LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(map(f));
        return this;
    }

    LatentImage transform(ColorTransformer f) {
        pendingOperations.add(f);
        return this;
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (ColorTransformer f : pendingOperations) c = f.apply(x, y, c);
                out.getPixelWriter().setColor(x, y, c);
            }
        return out;
    }

    private ColorTransformer map(UnaryOperator<Color> op) {
        return (x, y, c) -> op.apply(c);
    }
}

