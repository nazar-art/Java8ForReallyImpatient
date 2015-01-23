package com.tasks.capitel3;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * When you use a ReentrantLock, you are required to lock and unlock with the
 * idiom
 * myLock.lock();
 * try {
 * some action
 * } finally {
 * myLock.unlock();
 * }
 * Provide a method withLock so that one can call
 * withLock(myLock, () -> { some action })
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
