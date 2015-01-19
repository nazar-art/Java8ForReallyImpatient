package com.tasks.capitel8;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

/**
 * Date: 08.12.14
 */
public class C8E5 implements Exercise {

    @Test
    @Override
    public void perform() {
        ArrayList<String> words = new ArrayList<>(getWordsAsList());
        words.removeIf(w -> w.length() <= 12);
        assertEquals(33, words.size());
    }
}
