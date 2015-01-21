package com.tasks.capitel3;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Date: 01.11.14
 */
public class C3E2 implements Exercise {

    @Test
    @Override
    public void perform() {
        withLock(new ReentrantLock(), () -> System.out.println("some locked action"));
    }

    public void withLock(ReentrantLock lock, Runnable action) {
        lock.lock();
        try {
            action.run();
        } finally {
            lock.unlock();
        }
    }
}
