package com.tasks.capitel2;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.List;

/**
 * Verify that asking for the first five long words does not call the filter method
 * once the fifth long word has been found. Simply log each method call.
 */
public class C2E2 implements Exercise {

    @Test
    @Override
    public void perform() {
        List<String> words = getWordsAsList();
        words.stream().filter(s -> s.length() > 12)
                .limit(5).forEach(System.out::println);
    }
}

