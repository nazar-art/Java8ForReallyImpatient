package com.tasks.capitel2;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Date: 28.10.14
 */
public class C2E6 implements Exercise {

    @Test
    @Override
    public void perform() {
        characterStream("abcdef").forEach(System.out::println);
    }

    public Stream<Character> characterStream(String string) {
        return IntStream.range(0, string.length()).mapToObj(string::charAt);
    }
}
