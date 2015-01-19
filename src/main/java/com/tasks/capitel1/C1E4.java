package com.tasks.capitel1;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;

/**
 * Given an array of File objects, sort it so that the directories come before the
 * files, and within each group, elements are sorted by path name. Use a lambda
 * expression, not a Comparator.
 */
public class C1E4 implements Exercise {

    @Test
    @Override
    public void perform() {
        File[] files = sort("./src");
        System.out.println(new File(".").getAbsolutePath());
        Arrays.asList(files).forEach(System.out::println);
    }

    private static File[] sort(String dir) {
        File dirFile = new File(dir);
        File[] files = dirFile.listFiles();
        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            } else {
                return f1.getName().toLowerCase().compareTo(f2.getName().toLowerCase());
            }
        });
        return files;
    }
}
