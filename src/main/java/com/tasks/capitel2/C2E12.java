package com.tasks.capitel2;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class C2E12 implements Exercise {

    @Test
    @Override
    public void perform() {
        List<String> words = getWordsAsList();
        AtomicInteger[] shortWords = new AtomicInteger[12];
        words.parallelStream().forEach(
                w -> {
                    int length = w.length();
                    if (length < 12) {
                        AtomicInteger i = shortWords[length];
                        if (i == null) {
                            i = new AtomicInteger();
                            shortWords[length] = i;
                        }
                        i.incrementAndGet();
                    }
                }
        );
        Arrays.asList(shortWords).forEach(System.out::println);
    }
}
