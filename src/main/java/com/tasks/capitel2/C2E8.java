package com.tasks.capitel2;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.Assert.*;


/**
 * Write a method public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
 * that alternates elements from the streams first and second, stopping when
 * one of them runs out of elements.
 */
public class C2E8 implements Exercise {

    @Test
    @Override
    public void perform() {
        Stream<String> stream = zip(Stream.of("1", "2", "3"), Stream.of("a", "b"));
        assertEquals(4, stream.peek(System.out::println).count());
        System.out.println();
        stream = zip(Stream.of("1", "2", "3"), Stream.of("a", "b", "d", "e"));
        assertEquals(6, stream.peek(System.out::println).count());
    }

    public <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> secondAsIterator = second.iterator();
        Stream.Builder<T> builder = Stream.builder();
        first.forEach((e) -> {
            if (secondAsIterator.hasNext()) {
                builder.accept(e);
                builder.accept(secondAsIterator.next());
            } else {
                first.close();
            }
        });
        return builder.build();
    }
}
