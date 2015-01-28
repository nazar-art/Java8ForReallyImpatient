package com.tasks.capitel6;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.testng.Assert.assertTrue;

/**
 * Use a LongAccumulator to compute the maximum or minimum of the
 * accumulated elements.
 */
public class C6E4 implements Exercise {

    @Test
    @Override
    public void perform() {
        LongAccumulator maxAccumulator = new LongAccumulator(Math::max, 0);
        LongAccumulator minAccumulator = new LongAccumulator(Math::min, 10000);

        IntStream.range(0, 10).forEach(i ->
                new Thread(() ->
                        Stream.generate(Math::random).map(d ->
                                Double.valueOf(d * 10000).intValue()).limit(100).forEach(e -> {
                            maxAccumulator.accumulate(e);
                            minAccumulator.accumulate(e);
                        })).start());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(maxAccumulator.intValue() > 0);
        assertTrue(minAccumulator.intValue() < 10000);
    }
}
