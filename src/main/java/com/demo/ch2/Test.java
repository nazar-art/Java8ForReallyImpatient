package com.demo.ch2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test
{

    public static final String ALICE_PATH = "src\\main\\resources\\alice.txt";

    public static void main(String[] args) throws IOException
    {
        String contents = new String(Files.readAllBytes(Paths.get(ALICE_PATH)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long count = 0;
        long start = System.nanoTime();
        for (String w : words) {
            if (w.length() > 12) count++;
        }
        long end = System.nanoTime() - start;
        System.out.printf("%d%nhas running time %d%n", count, end);

        start = System.nanoTime();
        count = words.stream().filter(w -> w.length() > 12).count();
        end = System.nanoTime() - start;
        System.out.printf("%d%nrunning time %d%n", count, end);

        start = System.nanoTime();
        count = words.parallelStream().filter(w -> w.length() > 12).count();
        end = System.nanoTime() - start;
        System.out.printf("%d%nhas running time %d%n", count, end);

        Stream<Double> randoms = Stream.generate(Math::random);
        randoms.forEach(System.out::println);
    }
}
