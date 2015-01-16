package com.demo.ch2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReductionStream {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(Test.ALICE_PATH)), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("[\\P{L}]+"));

        Stream<String> words = wordList.stream();

        Optional<String> largest = words.max(String::compareToIgnoreCase);
        if (largest.isPresent())
            System.out.println("largest: " + largest.get());

        words = wordList.stream();
        boolean aWordStartsWithQ = words.anyMatch(s -> s.startsWith("Q"));
        System.out.println("a Word Starts With Q: " + aWordStartsWithQ);

        words = wordList.stream();
        Optional<String> startsWithQ = words.parallel().filter(s -> s.startsWith("Q")).findAny();
        if (startsWithQ.isPresent())
            System.out.println("starts With Q: " + startsWithQ.get());
        else
            System.out.println("No word starts with Q");
    }
}
