package com.tasks.capitel6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.PasswordAuthentication;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Write a method
 * public static <T> CompletableFuture<T> repeat(
 * Supplier<T> action, Predicate<T> until)
 * that asynchronously repeats the action until it produces a value that is
 * accepted by the until function, which should also run asynchronously. Test
 * with a function that reads a java.net.PasswordAuthentication from the console,
 * and a function that simulates a validity check by sleeping for a second and
 * then checking that the password is "secret". Hint: Use recursion.
 */
public class C6E11 {

    public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
        return CompletableFuture.supplyAsync(action).thenApplyAsync(r -> {
            if (until.test(r)) {
                return r;
            } else {
                return repeat(action, until).join();
            }
        });
    }

    public static void main(String[] args) {
        repeat(() -> {
                    try {
                        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                        System.out.print("Login: ");
                        String user = br.readLine();
                        System.out.print("Password: ");
                        char[] password = br.readLine().toCharArray();
                        return new PasswordAuthentication(user, password);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                },
                (a) -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {
                    }
                    return new String(a.getPassword()).equals("secret");
                }
        ).thenAccept((a) -> System.out.printf("Logged in: %s %s%n", a.getUserName(), new String(a.getPassword())));
        ForkJoinPool.commonPool().awaitQuiescence(3, TimeUnit.MINUTES);
    }
}
