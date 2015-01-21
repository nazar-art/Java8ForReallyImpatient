package com.tasks.capitel2;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.List;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Repeat the preceding exercise, but filter out the short strings and use the
 * collect method with Collectors.groupingBy and Collectors.counting.
 */
public class C2E13 implements Exercise {

    @Test
    @Override
    public void perform() {
        List<String> words = getWordsAsList();
        words.parallelStream()
                .filter(w -> w.length() < 12)
                .collect(groupingBy(String::length, counting()))
                .forEach((k, v) -> System.out.printf("%d - %d\n", k, v));
    }
}
