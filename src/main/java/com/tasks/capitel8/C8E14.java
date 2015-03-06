package com.tasks.capitel8;

import com.tasks.Exercise;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Demonstrate the use of the Objects.requireNonNull method and show how it
 * leads to more useful error messages.
 */
public class C8E14 implements Exercise {

    @Test(expected = NullPointerException.class)
    @Override
    public void perform() {
        test(null);
    }

    public void test(String a) {
        Objects.requireNonNull(a, () -> "[" + LocalDateTime.now() + "]: arg must not be null");
    }
}
