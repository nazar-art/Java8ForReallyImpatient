package com.demo.ch9.sec05;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

/**
 * @author Nazar_Lelyak.
 */
public class ProcessDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessBuilder builder = new ProcessBuilder("grep", "-o", "[A-Za-z_][A-Za-z_0-9]*");
        Path root = Paths.get("src/main/java/com/demo/ch9/sec05");
        builder.redirectInput(Paths.get(root.toString(), "/ProcessDemo.java").toFile());
        builder.redirectOutput(Paths.get(root.toString(), "identifiers.txt").toFile());
        Process process = builder.start();
        process.waitFor(1, TimeUnit.MINUTES);
    }
}