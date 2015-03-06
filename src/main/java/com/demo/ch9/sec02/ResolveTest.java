package com.demo.ch9.sec02;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Nazar_Lelyak.
 */
public class ResolveTest {
    public static void main(String[] args) {
        Path projectHome = Paths.get("");
        Path logFile = projectHome.resolve("log4j.properties");
        System.out.println(logFile);
    }
}
