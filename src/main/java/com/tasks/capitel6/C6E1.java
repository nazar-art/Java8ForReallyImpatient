package com.tasks.capitel6;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAccumulator;

/**
 * Date: 30.11.14
 */
public class C6E1 implements Exercise {

    @Test
    @Override
    public void perform() {
        AtomicReference<String> longest = new AtomicReference<>();
        LongAccumulator accumulator = new LongAccumulator(Math::max, 0);
        List<String> words = getWordsAsList();
        words.parallelStream().forEach(
                next -> longest.updateAndGet(
                        current -> {
                            String result = next.length() > accumulator.intValue() ? next : current;
                            accumulator.accumulate(next.length());
                            return result;
                        }));
        System.out.println(longest.get());
    }
}
