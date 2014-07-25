package com.demo.ch1;

import java.util.stream.Stream;

public class MainTest
{
    public static void main(String[] args)
    {
        Stream<String> infinityEchos = Stream.generate(() -> "Echo");
        infinityEchos.forEach(System.out::println);
    }
}
