package com.tasks.capitel9;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Write a program that reads the contents of a web page and saves it to a file.
 * Use URL.openStream and Files.copy.
 */
public class C9E7 {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.horstmann.com/");
            try (InputStream is = url.openStream()) {
                Files.copy(is, Paths.get(System.getProperty("java.io.tmpdir"), "test.html"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
