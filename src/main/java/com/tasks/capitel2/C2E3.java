package com.tasks.capitel2;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Measure the difference when counting long words with a parallelStream instead
 * of a stream. Call System.currentTimeMillis before and after the call, and print the
 * difference. Switch to a larger document (such as War and Peace) if you have
 * a fast computer.
 */
public class C2E3 implements Exercise {

    @Test
    @Override
    public void perform() {
        //It makes no sense - it should be done using a well-developed benchmarking framework
        System.out.println("start");
        List<String> words = getWordsAsListForPeace();
        long durationSeq = countDuration(words.stream());
        long durationParallel = countDuration(words.parallelStream());
        System.out.println("Seq: " + durationSeq + " - Parallel: " + durationParallel);
    }

    public long countDuration(Stream<String> stream) {
        long start = System.currentTimeMillis();
        stream.filter(s -> s.length() > 12).count();
        return System.currentTimeMillis() - start;
    }
}
