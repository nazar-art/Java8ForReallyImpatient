package com.demo.ch3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

public class ImageDemo5 extends Application {

    public static Color[][] parallelTransform(Color[][] in, UnaryOperator<Color> f) {
        int nProcessors = Runtime.getRuntime().availableProcessors();
        int height = in.length;
        int width = in[0].length;
        Color[][] out = new Color[height][width];
        try {
            ExecutorService pool = Executors.newCachedThreadPool();
            for (int i = 0; i < nProcessors; i++) {
                int fromY = i * height / nProcessors;
                int toY = (i + 1) * height / nProcessors;
                pool.submit(() -> {
                    System.out.printf("%s %d...%d\n", Thread.currentThread(), fromY, toY - 1);
                    for (int x = 0; x < width; x++)
                        for (int y = fromY; y < toY; y++)
                            out[y][x] = f.apply(in[y][x]);
                });
            }
            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return out;
    }

    public void start(Stage stage) {
        Image image = new Image("eiffel-tower.jpg");
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        Color[][] pixels = new Color[height][width];

        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                pixels[y][x] = image.getPixelReader().getColor(x, y);

        pixels = parallelTransform(pixels, Color::grayscale);
        WritableImage result = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                result.getPixelWriter().setColor(x, y, pixels[y][x]);

        stage.setScene(new Scene(new HBox(
                new ImageView(image),
                new ImageView(result))));
        stage.show();
    }
}

