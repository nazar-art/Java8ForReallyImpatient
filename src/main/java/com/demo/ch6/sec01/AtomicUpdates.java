package com.demo.ch6.sec01;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;

public class AtomicUpdates {
    public static int ntasks = 1000;
    public static int iterations = 1000;

    public static AtomicLong nextNumber = new AtomicLong(ntasks * iterations / 2);
    public static AtomicLong largest = new AtomicLong();

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();

        for (int border = 0; border < ntasks; border++)
            pool.submit(() -> {
                long start = nextNumber.incrementAndGet();
                for (int index = 0; index < iterations; index++) {
                    long observed = (start + ntasks * index) % (ntasks * iterations);
                    // Error—race condition!
                    largest.set(Math.max(largest.get(), observed));
                }
            });
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(largest);
        // Should be 999999, but ever so often, it isn't
    }
}