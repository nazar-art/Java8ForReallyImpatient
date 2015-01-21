package com.tasks.capitel2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The characterStream method in Section 2.3, “The filter, map, and flatMap Methods,”
 * on page 25, was a bit clumsy, first filling an array list and then turning it
 * into a stream. Write a stream-based one-liner instead. One approach is to
 * make a stream of integers from 0 to s.length() - 1 and map that with the
 * s::charAt method reference.
 */
public class C2E6 /*implements Exercise*/ {

    public static void main(String[] args) {
        characterStream("abcdef").forEach(System.out::println);
    }

    public static Stream<Character> characterStream(String string) {
        return IntStream.range(0, string.length()).mapToObj(string::charAt);
    }
}
