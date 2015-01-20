package com.demo.ch2;

import com.tasks.Exercise;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamModificationTest implements Exercise {
    public static void main(String[] args) {
        StreamModificationTest test = new StreamModificationTest();
        List<String> wordsAsList = test.getWordsAsList();
//        longerThen12(wordsAsList);
        Optional<String> startsFromQ = wordsAsList.parallelStream().filter(s -> s.startsWith("Q")).findAny();
        if (startsFromQ.isPresent()) {
            System.out.println(startsFromQ.get());
        }

//        Optional<String> largest = wordsAsList.stream().skip(1).max(String::compareToIgnoreCase);
//        if (largest.isPresent()) {
//            System.out.println("Largest word: " + largest.get());
//        }
    }

    private static void longerThen12(List<String> wordsAsList) {
        Stream<String> words = wordsAsList.stream();

        Stream<String> longWords = words.filter(w -> w.length() > 12).map(String::toLowerCase);
        consolePrint(longWords);
    }

    private static void consolePrint(Stream<String> longWords) {
        longWords.forEach(System.out::println);
    }

    @Override
    public void perform() {
        throw new NotImplementedException();
    }
}
