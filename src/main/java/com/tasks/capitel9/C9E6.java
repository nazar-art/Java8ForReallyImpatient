package com.tasks.capitel9;

import com.demo.ch2.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Write a program that reads all lines of a file and writes them out in reverse
 * order. Use Files.readAllLines and Files.write.
 */
public class C9E6 {

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(Test.ALICE_PATH));
            Collections.reverse(lines);
            Files.write(Paths.get("aliceReversedByLines.txt"), lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
