package com.tasks.capitel3;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.testng.Assert.assertTrue;

/**
 * Date: 15.11.14
 */
public class C3E20 implements Exercise {

    @Test
    @Override
    public void perform() {
        List<Integer> ints = map(Arrays.asList("1", "2", "3"), Integer::parseInt);
        assertTrue(ints.size() == 3);
    }

    public static <T, U> List<U> map(List<T> list, Function<T, U> mapper) {
        return list.stream().map(mapper).collect(Collectors.toList());
    }
}
