package com.demo.ch2;

import java.math.BigInteger;
import java.util.stream.Stream;

public class InfinityStream
{
    public static void main(String[] args)
    {
//        infinityStream();
        limitStream();
    }

    private static void limitStream()
    {
        Stream<Double> randoms = Stream.generate(Math::random).limit(100);
        randoms.forEach(System.out::println);
    }

    private static void infinityStream()
    {
        Stream<BigInteger> integers   = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        integers.forEach(System.out::println);
    }
}
