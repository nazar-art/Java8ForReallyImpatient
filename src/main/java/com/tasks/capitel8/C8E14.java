package com.tasks.capitel8;

import com.tasks.Exercise;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Date: 13.12.14
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
