package com.tasks.capitel2;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Join all elements in a Stream<ArrayList<T>> to one ArrayList<T>.
 * Show how to do this with the three forms of reduce.
 */
public class C2E9 implements Exercise {

    public static final int SIZE_OF_FIVE = 5;

    @Test
    @Override
    public void perform() {
        List<ArrayList<String>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList("1", "2", "3")));
        list.add(new ArrayList<>(Arrays.asList("a", "b")));

        List<String> list1 = join(list.stream());
        assertEquals(SIZE_OF_FIVE, list1.size());
        assertEquals(SIZE_OF_FIVE, join(list.parallelStream()).size());
        list1.forEach(System.out::print);
        System.out.println();

        List<String> list2 = joinUsingReduce1(list.stream());
        assertEquals(SIZE_OF_FIVE, list2.size());
        assertEquals(SIZE_OF_FIVE, joinUsingReduce1(list.parallelStream()).size());
        list2.forEach(System.out::print);
        System.out.println();

        List<String> list3 = joinUsingReduce2(list.stream());
        assertEquals(SIZE_OF_FIVE, list3.size());
        assertEquals(SIZE_OF_FIVE, joinUsingReduce2(list.parallelStream()).size());
        list3.forEach(System.out::print);
        System.out.println();

        List<String> list4 = joinUsingReduce3(list.stream());
        assertEquals(SIZE_OF_FIVE, list4.size());
        assertEquals(SIZE_OF_FIVE, joinUsingReduce3(list.parallelStream()).size());
        list4.forEach(System.out::print);
        System.out.println();
    }

    public List<String> join(Stream<ArrayList<String>> stream) {
        return stream.flatMap(list -> list.stream()).collect(Collectors.toList());
    }

    public List<String> joinUsingReduce1(Stream<ArrayList<String>> stream) {
        return stream.reduce((l, e) -> {
            ArrayList<String> list = new ArrayList<>(l);
            list.addAll(e);
            return list;
        }).orElse(new ArrayList<>());
    }

    public List<String> joinUsingReduce2(Stream<ArrayList<String>> stream) {
        return stream.reduce(new ArrayList<>(),
                (l, e) -> {
                    ArrayList<String> list = new ArrayList<>(l);
                    list.addAll(e);
                    return list;
                });
    }

    public List<String> joinUsingReduce3(Stream<ArrayList<String>> stream) {
        return stream.reduce(new ArrayList<>(),
                (l, e) -> {
                    ArrayList<String> list = new ArrayList<>(l);
                    list.addAll(e);
                    return list;
                },
                (l, e) -> {
                    ArrayList<String> list = new ArrayList<>(l);
                    list.addAll(e);
                    return list;
                }
        );
    }


}
