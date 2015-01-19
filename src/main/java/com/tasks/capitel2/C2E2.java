package com.tasks.capitel2;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Date: 28.10.14
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

