package com.tasks.capitel2;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.*;

/**
 * Write a parallel version of the for loop in Section 2.1, “From Iteration to
 * Stream Operations,” on page 22. Obtain the number of processors. Make that
 * many separate threads, each working on a segment of the list, and total up
 * the results as they come in. (You don’t want the threads to update a single
 * counter. Why?)
 */
public class C2E1 implements Exercise {

    @Test
    @Override
    public void perform() {
        List<String> words = getWordsAsList();
        assertEquals(words.parallelStream().filter(s -> s.length() > 12).count(), countConcurrentWithoutStreams(words));
    }

    private static long countConcurrentWithoutStreams(List<String> words) {
        try {
            int cores = Runtime.getRuntime().availableProcessors();
            int chunkSize = words.size() / cores;
            List<List<String>> chunks = new LinkedList<>();
            for (int i = 0; i < words.size(); i += chunkSize) {
                chunks.add(words.subList(i, i + Math.min(chunkSize, words.size() - i)));
            }
            ExecutorService pool = Executors.newFixedThreadPool(cores);
            Set<Future<Long>> set = new HashSet<>();
            for (List<String> strings : chunks) {
                Callable<Long> callable = () -> {
                    long chunkCount = 0;
                    for (String string : strings) {
                        if (string.length() > 12) chunkCount++;
                    }
                    return chunkCount;
                };
                Future<Long> future = pool.submit(callable);
                set.add(future);
            }
            long count = 0;
            for (Future<Long> future : set) {
                count += future.get();
            }
            pool.shutdown();
            return count;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
