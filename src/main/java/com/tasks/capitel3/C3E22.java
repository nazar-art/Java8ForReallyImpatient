package com.tasks.capitel3;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Date: 15.11.14
 */
public class C3E22 implements Exercise {

    @Test
    @Override
    public void perform() {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "1", executor);
        try {
            future.thenApply(Integer::parseInt)                                                //map
                    .thenCompose((a) -> CompletableFuture.supplyAsync(() -> 1 + a, executor))  //flatMap
                    .thenAccept(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
