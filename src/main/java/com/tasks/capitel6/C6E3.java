package com.tasks.capitel6;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/**
 * Generate 1,000 threads, each of which increments a counter 100,000 times.
 * Compare the performance of using AtomicLong versus LongAdder.
 */
public class C6E3 {

    public static void main(String[] args) {
        C6E3 e3 = new C6E3();
        e3.testAtomicLong();
        e3.testLongAdder();
    }

    public void testAtomicLong() {
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        long start = System.currentTimeMillis();
        AtomicLong counter = new AtomicLong();
        CompletableFuture[] futures = new CompletableFuture[1000];

        IntStream.range(0, 1000).forEach(i ->
                futures[i] = CompletableFuture.runAsync(() ->
                        IntStream.range(0, 100_000).forEach(j ->
                                counter.incrementAndGet()), executor));

        CompletableFuture.allOf(futures).thenAccept((v) -> {
            assertEquals(100_000_000, counter.get());
            System.out.printf("AtomicLong: %d%n", System.currentTimeMillis() - start);
        });
        executor.shutdownNow();
    }

    public void testLongAdder() {
        ExecutorService executor = Executors.newFixedThreadPool(1000);
        long start = System.currentTimeMillis();
        LongAdder counter = new LongAdder();
        CompletableFuture[] futures = new CompletableFuture[1000];

        IntStream.range(0, 1000).forEach(i ->
                futures[i] = CompletableFuture.runAsync(() ->
                        IntStream.range(0, 100_000).forEach(j ->
                                counter.increment()), executor));

        CompletableFuture.allOf(futures).thenAccept((v) -> {
            assertEquals(100_000_000, counter.sum());
            System.out.printf("AtomicAdder: %d%n", System.currentTimeMillis() - start);
        });
        executor.shutdownNow();
    }


}
