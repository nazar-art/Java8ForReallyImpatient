package com.demo.ch2.sec07;

import com.demo.FileLocator;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(FileLocator.WAR_AND_PEACE_TXT)), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("[\\P{L}]+"));

        Optional<String> optionalValue = wordList.stream().filter(s -> s.contains("red")).findFirst();

        optionalValue.ifPresent(s -> System.out.println(s + " contains red"));

        Set<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);
        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println(added);

        optionalValue = wordList.stream().filter(s -> s.contains("fred")).findFirst();

        System.out.println(optionalValue.orElse("No word") + " contains fred");

        Optional<String> optionalString = Optional.empty();
        String result = optionalString.orElse("N/A");
        System.out.println("result: " + result);

        result = optionalString.orElseGet(() -> System.getProperty("user.dir"));
        System.out.println("result: " + result);
        try {
            result = optionalString.orElseThrow(NoSuchElementException::new);
            System.out.println("result: " + result);
        } catch (Throwable t) {
            t.printStackTrace();
        }

        System.out.println(inverse(4.0).flatMap(Test::squareRoot));
        System.out.println(inverse(-1.0).flatMap(Test::squareRoot));
        System.out.println(inverse(0.0).flatMap(Test::squareRoot));
        System.out.println(Optional.of(-4.0).flatMap(Test::inverse).flatMap(Test::squareRoot));
    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }
}



