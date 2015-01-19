package com.tasks.capitel1;

import com.tasks.Exercise;
import org.testng.annotations.Test;

/**
 * Didn’t you always hate it that you had to deal with checked exceptions in a
 * Runnable? Write a method uncheck that catches all checked exceptions and turns
 * them into unchecked exceptions. For example,
 * new Thread(uncheck(
 * () -> { System.out.println("Zzz"); Thread.sleep(1000); })).start();
 * // Look, no catch (InterruptedException)!
 * Hint: Define an interface RunnableEx whose run method may throw any exceptions.
 * Then implement public static Runnable uncheck(RunnableEx runner). Use a
 * lambda expression inside the uncheck function.
 * Why can’t you just use Callable<Void> instead of RunnableEx?
 */
public class C1E6 implements Exercise {

    @Test
    @Override
    public void perform() {
        new Thread(
                uncheck(
                        () -> {
                            System.out.println("Zzz");
                            Thread.sleep(1000);
                        }
                )
        ).start();
    }

    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception ignored) {
            }
        };
    }
}

@FunctionalInterface
interface RunnableEx {

    void run() throws Exception;

}
