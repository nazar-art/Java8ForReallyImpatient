package com.tasks.capitel2;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * Using Stream.iterate, make an infinite stream of random numbers—not by
 * calling Math.random but by directly implementing a linear congruential generator.
 * In such a generator, you start with x0 = seed and then produce xn + 1 =
 * (a xn + c) % m, for appropriate values of a, c, and m. You should implement a
 * method with parameters a, c, m, and seed that yields a Stream<Long>. Try out a =
 * 25214903917, c = 11, and m = 248.
 */
public class C2E5 implements Exercise {

    @Test
    @Override
    public void perform() {
        randomStream(0, 25214903917L, 11, 248L)
                .limit(10)
                .forEach(System.out::println);
    }

    public Stream<Long> randomStream(long seed, long a, long c, long m) {
        return Stream.iterate(seed, e -> (a * e + c) % m);
    }
}
