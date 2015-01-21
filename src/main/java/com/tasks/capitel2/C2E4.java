package com.tasks.capitel2;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Suppose you have an array int[] values = { 1, 4, 9, 16 }. What is
 * Stream.of(values)? How do you get a stream of int instead?
 */
public class C2E4 implements Exercise {

    @Test
    @Override
    public void perform() {
        int[] values = {1, 4, 9, 16};
        Stream<int[]> of = Stream.of(values);
        IntStream streamOfInts = Arrays.stream(values);
        streamOfInts.forEach(System.out::println);
    }
}
