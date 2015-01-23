package com.tasks.capitel3;

import com.tasks.Exercise;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.function.Function;

/**
 * Implement a version of the unchecked method in Section 3.8, “Dealing with
 * Exceptions,” on page 58, that generates a Function<T, U> from a lambda that
 * throws checked exceptions. Note that you will need to find or provide a
 * functional interface whose abstract method throws arbitrary exceptions.
 */
public class C3E18 implements Exercise {

    @FunctionalInterface
    public interface FunctionThatThrows<T, R> {
        R apply(T t) throws Exception;
    }

    @Override
    @Test(expected = RuntimeException.class)
    public void perform() {
        unchecked((String p) -> Files.readAllBytes(Paths.get(p)).length).apply("/dummy.txt");
    }

    public <T, R> Function<T, R> unchecked(FunctionThatThrows<T, R> f) {
        return (a) -> {
            try {
                return f.apply(a);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }
}
