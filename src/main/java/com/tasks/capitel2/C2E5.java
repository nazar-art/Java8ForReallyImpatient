package com.tasks.capitel2;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.util.stream.Stream;

/**
 * Date: 28.10.14
 */
public class C2E5 implements Exercise {

    @Test
    @Override
    public void perform() {
        randomStream(System.currentTimeMillis(), 25214903917l, 11, (long) Math.pow(2, 48))
                .limit(10)
                .forEach(System.out::println);
    }

    public Stream<Long> randomStream(long seed, long a, long c, long m) {
        return Stream.iterate(seed, e -> (a * e + c) % m);
    }
}
