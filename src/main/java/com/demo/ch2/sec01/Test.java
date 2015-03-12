package com.demo.ch2.sec01;

import com.demo.FileLocator;
import com.utils.StopWatch;

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
        StopWatch timer = new StopWatch();
        String contents = new String(Files.readAllBytes(Paths.get(FileLocator.WAR_AND_PEACE_TXT)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        timer.start();
        long count = 0;
        for (String w : words) {
            if (w.length() > 12) count++;
        }
        timer.stop();
        System.out.printf("iterative       - %d words - %d milliseconds\n", count, timer.getElapsedTime());
        timer.reset();

        timer.start();
        count = words.stream().filter(w -> w.length() > 12).count();
        timer.stop();
        System.out.printf("stream          - %d words - %d milliseconds\n", count, timer.getElapsedTime());
        timer.reset();

        timer.start();
        count = words.parallelStream().filter(w -> w.length() > 12).count();
        timer.stop();
        System.out.printf("parallel stream - %d words - %d milliseconds\n", count, timer.getElapsedTime());
        timer.reset();
    }
}
