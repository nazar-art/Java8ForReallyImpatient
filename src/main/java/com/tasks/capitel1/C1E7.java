package com.tasks.capitel1;

import com.tasks.Exercise;
import org.junit.Test;

/**
 * Write a static method andThen() that takes as parameters two Runnable instances
 * and returns a Runnable that runs the first, then the second. In the main method,
 * pass two lambda expressions into a call to andThen, and run the returned
 * instance.
 */
public class C1E7 implements Exercise {

    @Test
    @Override
    public void perform() {
        new Thread(
                andThen(
                        () -> System.out.println("First"),
                        () -> System.out.println("Second")
                )).start();
    }

    public static Runnable andThen(Runnable first, Runnable second) {
        return () -> {
            first.run();
            second.run();
        };
    }
}
