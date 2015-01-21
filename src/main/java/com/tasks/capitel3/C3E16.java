package com.tasks.capitel3;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * Date: 14.11.14
 */
public class C3E16 implements Exercise {

    @Override
    @Test
    public void perform() {
        this.doInOrderAsync(
                () -> Integer.parseInt("a"),
                (i, e) -> {
                    if (i != null) {
                        System.out.printf("Parsed int: %d", i);
                    } else {
                        if (e instanceof NumberFormatException) {
                            System.out.printf("Couldn't parse, using defaults");
                        } else {
                            System.out.println("Something bad happened");
                        }
                    }
                }
        );
    }

    public <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
        Thread t = new Thread() {
            public void run() {
                try {
                    T result = first.get();
                    second.accept(result, null);
                } catch (Throwable t) {
                    second.accept(null, t);
                }
            }
        };
        t.start();
    }
}
