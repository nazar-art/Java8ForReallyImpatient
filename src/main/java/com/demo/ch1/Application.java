package com.demo.ch1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {

        // Path first = Paths.get("/usr/bin");
        // Uncomment to see error "variable first is already defined"
        // in the lambda expression below

        Comparator<String> comp = (first, second) -> Integer.compare(first.length(), second.length());
        System.out.println(comp.compare("hello", "world!"));
        Application app = new Application();
        app.doWork();

        Stream<Integer> stream = Stream.empty();
        Integer[] array = stream.toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));
    }

    public void doWork() {
        Runnable runner = () -> {
            System.out.println(this.toString());
        };
        runner.run();
        // Prints Application@... since this refers to an Application object
    }
}
