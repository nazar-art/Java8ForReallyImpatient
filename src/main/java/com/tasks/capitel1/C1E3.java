package com.tasks.capitel1;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;


/**
 * Using the list(FilenameFilter) method of the java.io.File class, write a method
 * that returns all files in a given directory with a given extension. Use a lambda
 * expression, not a FilenameFilter. Which variables from the enclosing scope does
 * it capture?
 */
public class C1E3 implements Exercise {

    @Test
    @Override
    public void perform() {
        File[] files = list(".", "xml");
        Arrays.asList(files).forEach(System.out::println);
    }

    private static File[] list(String dir, String ext) {
        File dirFile = new File(dir);
        return dirFile.listFiles(f -> f.getName().endsWith(ext));
    }
}
