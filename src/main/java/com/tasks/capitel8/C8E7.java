package com.tasks.capitel8;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.Arrays;

import static java.util.Comparator.nullsLast;
import static java.util.Comparator.reverseOrder;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

/**
 * Express nullsFirst(naturalOrder()).reversed() without calling reversed.
 */
public class C8E7 implements Exercise {

    @Test
    @Override
    public void perform() {
        String[] words = {
                "bbb",
                "aaa",
                null,
                "ccc"
        };
        Arrays.sort(words, nullsLast(reverseOrder()));
        assertEquals("ccc", words[0]);
        assertEquals("bbb", words[1]);
        assertEquals("aaa", words[2]);
        assertNull(words[3]);
    }

}
