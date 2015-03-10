package com.demo.ch2.sec01;

import com.demo.FileLocators;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author Nazar_Lelyak.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get(FileLocators.ALICE_TXT)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long count = 0;
        for (String w : words) {
            if (w.length() > 12) count++;
        }
        System.out.println(count);

        count = words.stream().filter(w -> w.length() > 12).count();
        System.out.println(count);


        count = words.parallelStream().filter(w -> w.length() > 12).count();
        System.out.println(count);
    }
}
