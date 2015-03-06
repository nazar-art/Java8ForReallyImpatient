package com.tasks.capitel8;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * At the beginning of Chapter 2, we counted long words in a list as
 * words.stream().filter(w -> w.length() > 12).count(). Do the same with a lambda
 * expression, but without using streams. Which operation is faster for a
 * long list?
 */
public class C8E5 implements Exercise {

    @Test
    @Override
    public void perform() {
        ArrayList<String> words = new ArrayList<>(getWordsAsList());
        words.removeIf(w -> w.length() <= 12);
        assertEquals(34, words.size());
    }
}
