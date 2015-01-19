package com.tasks.capitel3;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.util.function.BooleanSupplier;

/**
 * Date: 01.11.14
 */
public class C3E3 implements Exercise {

    @Test(expectedExceptions = AssertionError.class)
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
