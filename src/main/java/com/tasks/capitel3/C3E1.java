package com.tasks.capitel3;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Enhance the lazy logging technique by providing conditional logging. A
 * typical call would be logIf(Level.FINEST, () -> i == 10, () -> "a[10] = " + a[10]).
 * Don’t evaluate the condition if the logger won’t log the message.
 */
public class C3E1 implements Exercise {

    @Test
    @Override
    public void perform() {
        Logger.getGlobal().setLevel(Level.OFF);
        logIf(Level.INFO, () -> true, () -> "you'll never see it");
        Logger.getGlobal().setLevel(Level.ALL);
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int index = 0; index < array.length; index++) {
            log(index, array);
        }
    }

    private void log(int i, int[] a) {
        logIf(Level.INFO, () -> i == 10, () -> "a[10] = " + a[10]);
    }

    public void logIf(Level level, Supplier<Boolean> condition, Supplier<String> message) {
        Logger logger = Logger.getGlobal();
        if (logger.isLoggable(level)   //evaluate condition only if the logger will log the message
                && condition.get()) {
            logger.log(level, message.get());
        }
    }
}
