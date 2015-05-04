package com.tasks.capitel9;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * Using the ProcessBuilder class, write a program that calls grep -r to look for
 * credit card numbers in all files in any subdirectory of the user’s home
 * directory. Collect the numbers that you found in a file.
 */
public class C9E11 {

    public static void main(String[] args) {
        try {
            scan();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scan() throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("grep",
                "-ohr",
                "-E",
                "-I",
                "--color=never",
                "(\\d{4}[ -]){3}\\d{4}",
                System.getProperty("java.io.tmpdir"))
                .redirectOutput(Paths.get(System.getProperty("user.home"), "cards.txt").toFile());
        builder.start().waitFor(5, TimeUnit.MINUTES);
    }

}
