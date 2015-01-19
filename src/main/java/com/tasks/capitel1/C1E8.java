package com.tasks.capitel1;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * What happens when a lambda expression captures values in an enhanced
 * for loop such as this one?
 * String[] names = { "Peter", "Paul", "Mary" };
 * List<Runnable> runners = new ArrayList<>();
 * for (String name : names)
 * runners.add(() -> System.out.println(name));
 * Is it legal? Does each lambda expression capture a different value, or do they
 * all get the last value? What happens if you use a traditional loop for (int i = 0;
 * i < names.length; i++)?
 */
public class C1E8 implements Exercise {

    @Test
    @Override
    public void perform() {
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for (String name : names) {
            runners.add(() -> System.out.println(name));
        }
        for (Runnable runner : runners) {
            new Thread(runner).start();
        }
        runners.clear();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            runners.add(() -> System.out.println(name));
        }
        for (Runnable runner : runners) {
            new Thread(runner).start();
        }
    }
}
/*
Foreach:
    Paul
    Mary
    Peter
    Peter
    Paul
    Mary

For:
    Paul
    Peter
    Mary
    Peter
    Mary
    Paul
 */
