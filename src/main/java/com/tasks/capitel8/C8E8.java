package com.tasks.capitel8;

import com.tasks.Exercise;
import org.junit.Test;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Write a program that demonstrates the benefits of the CheckedQueue class.
 */
public class C8E8 implements Exercise {

    @Test(expected = ClassCastException.class)
    @Override
    public void perform() {
        Queue<URL> queue = Collections.checkedQueue(new LinkedList<>(), URL.class);
        test(queue);
    }

    @SuppressWarnings("unchecked")
    public void test(Queue queue) {
        queue.add("test");
    }
}
