package com.tasks.capitel2;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Stream;

/**
 * Date: 28.10.14
 */
public class C2E3 implements Exercise {

    @Test
    @Override
    public void perform() {
        //It makes no sense - it should be done using a well-developed benchmarking framework
        List<String> words = getWordsAsList();
        long durationSeq = countDuration(words.stream());
        long durationParallel = countDuration(words.parallelStream());
        System.out.printf("Seq: %d - Parallel: %d", durationSeq, durationParallel);
    }

    public long countDuration(Stream<String> stream) {
        long start = System.currentTimeMillis();
        stream.filter(s -> s.length() > 12).count();
        return System.currentTimeMillis() - start;
    }


}
