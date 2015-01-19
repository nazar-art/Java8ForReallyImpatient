package com.tasks.capitel8;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

/**
 * Date: 13.12.14
 */
public class C8E15 implements Exercise {

    @Test
    @Override
    public void perform() {
        try {
            grep(Pattern.compile("(?m)^Alice"),
                    Paths.get(this.getClass().getResource("/alice.txt").toURI()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void grep(Pattern pattern, Path path) throws IOException {
        Files.lines(path).filter(pattern.asPredicate()).forEach(System.out::println);
    }

}
