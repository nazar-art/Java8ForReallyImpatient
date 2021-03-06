package com.tasks.capitel3;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.concurrent.*;
import java.util.function.Function;

import static org.junit.Assert.*;

/**
 * Supply a static method <T, U> Future<U> map(Future<T>, Function<T, U>). Return an
 * object of an anonymous class that implements all methods of the Future
 * interface. In the get methods, invoke the function.
 */
public class C3E21 implements Exercise {

    @Test
    @Override
    public void perform() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> strFuture = executorService.submit(() -> "1");
        Future<Integer> intFuture = map(strFuture, Integer::parseInt);
        try {
            assertEquals(new Integer(1), intFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T, U> Future<U> map(Future<T> future, Function<T, U> mapper) {
        return new Future<U>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return future.cancel(mayInterruptIfRunning);
            }

            @Override
            public boolean isCancelled() {
                return future.isCancelled();
            }

            @Override
            public boolean isDone() {
                return future.isDone();
            }

            @Override
            public U get() throws InterruptedException, ExecutionException {
                return mapper.apply(future.get());
            }

            @Override
            public U get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return mapper.apply(future.get(timeout, unit));
            }
        };
    }
}
