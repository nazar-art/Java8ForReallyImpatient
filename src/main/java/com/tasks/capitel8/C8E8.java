package com.tasks.capitel8;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Date: 08.12.14
 */
public class C8E8 implements Exercise {

    @Test(expectedExceptions = ClassCastException.class)
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
