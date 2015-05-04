package com.tasks.capitel9;

import com.demo.ch2.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Write a program that reads all characters of a file and writes them out in
 * reverse order. Use Files.readAllBytes and Files.write.
 */
public class C9E5 {

    public static void main(String[] args) {
        Path absolute = Paths.get("").toAbsolutePath();

//        reverseFileByLines(absolute, "reversedAlice.txt");
        reverseFileByBytes(absolute, "aliceReversedByChars.txt");
    }

    private static void reverseFileByBytes(Path absolute, String outFile) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(Test.ALICE_PATH));
            byte[] reversedBytes = new byte[bytes.length];
            for (int index = 0, border = bytes.length - 1; index < bytes.length; index++, border--) {
                reversedBytes[index] = bytes[border];
            }
            Files.write(Paths.get(absolute.toString(), outFile), reversedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void reverseFileByLines(Path absolute, String outFile) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(Test.ALICE_PATH), StandardCharsets.UTF_8);
            Collections.reverse(lines);
            Files.write(Paths.get(absolute.toString(), outFile), lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
