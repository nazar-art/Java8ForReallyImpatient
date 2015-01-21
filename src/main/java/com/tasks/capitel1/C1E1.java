package com.tasks.capitel1;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArraySet;

import static org.junit.Assert.*;

/**
 * Is the comparator code in the Arrays.sort method called in the same thread as
 * the call to sort or a different thread?
 */
public class C1E1 implements Exercise {

    @Test
    @Override
    public void perform() {
        final long currentThreadId = Thread.currentThread().getId();
        String[] array = getWordsAsArray();
        //sort
        CopyOnWriteArraySet<Long> threadIds = new CopyOnWriteArraySet<>();
        Arrays.sort(array, (a, b) -> {
            threadIds.add(Thread.currentThread().getId());
            return a.compareTo(b);
        });
        assertEquals(1, threadIds.size());
        assertEquals(currentThreadId, threadIds.toArray()[0]);

        //parallelSort
        threadIds.clear();
        Arrays.parallelSort(array, (a, b) -> {
            threadIds.add(Thread.currentThread().getId());
            return a.compareTo(b);
        });
        assertTrue(threadIds.size() > 1);
    }

}
