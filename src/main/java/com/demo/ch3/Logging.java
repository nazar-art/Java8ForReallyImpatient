package com.demo.ch3;

import java.util.function.IntConsumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Logging {
    public static void info(Logger logger, Supplier<String> message) {
        if (logger.isLoggable(Level.INFO))
            logger.info(message.get());
    }

    public static void repeat(int n, IntConsumer action) {
        for (int i = 0; i < n; i++) action.accept(i);
    }

    public static void repeat2(int n, Runnable action) {
        for (int i = 0; i < n; i++) {
            action.run();
        }
    }

    public static void main(String[] args) {
        double x = 3;
        double y = 4;
        info(Logger.getGlobal(), () -> "x: " + x + ", y: " + y);

        System.out.println();
        repeat(10, i -> System.out.println("Countdown: " + (9 - i)));
        repeat2(10, () -> System.out.println("Hello world!"));
    }
}

