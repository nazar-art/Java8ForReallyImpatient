package com.tasks.capitel3;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.function.BooleanSupplier;

/**
 * Java 1.4 added assertions to the language, with an assert keyword. Why were
 * assertions not supplied as a library feature? Could they be implemented as
 * a library feature in Java 8?
 */
public class C3E3 implements Exercise {

    @Test(expected = AssertionError.class)
    @Override
    public void perform() {
        assertThat(() -> 2 * 2 == 5);
    }

    public void assertThat(BooleanSupplier assertion) {
        if (!assertion.getAsBoolean()) {
            throw new AssertionError();
        }
    }
}
