package com.demo.ch2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {

    public static Stream<String> noVowels(String filename) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(filename)), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("[\\P{L}]+"));
        Stream<String> words = wordList.stream();
        return words.map(s -> s.replaceAll("[aeiouAEIOU]", ""));
    }

    public static <T> void show(String label, Set<T> set) {
        System.out.print(label + ": " + set.getClass().getName());
        System.out.println("[" +
                set.stream().limit(10).map(Object::toString).collect(Collectors.joining(", "))
                + "]");
    }

    public static void main(String[] args) throws IOException {
        Iterator<Integer> iter = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        while (iter.hasNext()) System.out.println(iter.next());

        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println(Arrays.toString(numbers)); // Note it's an Object[] array

        try {
            Integer number = (Integer) numbers[0]; // OK
            System.out.println("number: " + number);
            Integer[] numbers2 = (Integer[]) numbers; // Throws exception
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

        Integer[] numbers3 = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
        System.out.println(Arrays.toString(numbers3)); // Note it's an Integer[] array

        HashSet<String> noVowelHashSet
                = noVowels(Test.ALICE_PATH).collect(HashSet::new, HashSet::add, HashSet::addAll);

        show("noVowelHashSet", noVowelHashSet);

        Set<String> noVowelSet
                = noVowels(Test.ALICE_PATH).collect(Collectors.toSet());
        show("noVowelSet", noVowelSet);

        TreeSet<String> noVowelTreeSet
                = noVowels(Test.ALICE_PATH).collect(Collectors.toCollection(TreeSet::new));
        show("noVowelTreeSet", noVowelTreeSet);

        String result = noVowels(Test.ALICE_PATH).limit(10).collect(Collectors.joining());
        System.out.println(result);
        result = noVowels(Test.ALICE_PATH).limit(10).collect(Collectors.joining(", "));
        System.out.println(result);

        IntSummaryStatistics summary = noVowels(Test.ALICE_PATH).collect(
                Collectors.summarizingInt(String::length));
        double averageWordLength = summary.getAverage();
        double maxWordLength = summary.getMax();
        System.out.println("Average word length: " + averageWordLength);
        System.out.println("Max word length: " + maxWordLength);

        noVowels(Test.ALICE_PATH).limit(10).forEach(System.out::println);
    }
}
