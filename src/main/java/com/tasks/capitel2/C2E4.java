package com.tasks.capitel2;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Date: 28.10.14
 */
public class C2E4 implements Exercise {

    @Test
    @Override
    public void perform() {
        int[] values = {1, 4, 9, 16};
        IntStream streamOfInts = Arrays.stream(values);
        streamOfInts.forEach(System.out::println);
    }
}
