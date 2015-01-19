package com.tasks.capitel2;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

/**
 * Date: 28.10.14
 */
public class C2E9 implements Exercise {

    @Test
    @Override
    public void perform() {
        List<ArrayList<String>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList("1", "2", "3")));
        list.add(new ArrayList<>(Arrays.asList("a", "b")));
        assertEquals(5, join(list.stream()).size());
        assertEquals(5, join(list.parallelStream()).size());
        assertEquals(5, joinUsingReduce1(list.stream()).size());
        assertEquals(5, joinUsingReduce1(list.parallelStream()).size());
        assertEquals(5, joinUsingReduce2(list.stream()).size());
        assertEquals(5, joinUsingReduce2(list.parallelStream()).size());
        assertEquals(5, joinUsingReduce3(list.stream()).size());
        assertEquals(5, joinUsingReduce3(list.parallelStream()).size());
    }

    public List<String> join(Stream<ArrayList<String>> stream) {
        return stream.flatMap(e -> e.stream()).collect(Collectors.toList());
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
