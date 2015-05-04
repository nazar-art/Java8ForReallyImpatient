package com.demo.ch9.sec02;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;

/**
 * @author Nazar_Lelyak.
 */
public class FilesDemo {
    public static void main(String[] args) throws IOException {
        String root = "src/main/java/com/demo/ch9/sec02";
        Path path = Paths.get(root, "/FilesDemo.java");
        // read file as bytes
        byte[] bytes = Files.readAllBytes(path);

        // read full file as string
        String content = new String(bytes, StandardCharsets.UTF_8);
        System.out.println(content.substring(0, 100) + "...");

        // read full file as list of strings
        List<String> lines = Files.readAllLines(path);
        System.out.println("Last line: " + lines.get(lines.size() - 1));

        path = Paths.get(root, "FilesDemo1.out");
        content = content.replaceAll("e", "x");
        Files.write(path, content.getBytes(StandardCharsets.UTF_8));
        path = Paths.get(root, "FilesDemo2.out");
        Files.write(path, lines);
        Collections.reverse(lines);
        Files.write(path, lines, StandardOpenOption.APPEND);

        URL url = new URL("http://horstmann.com");
        boolean deleted = Files.deleteIfExists(Paths.get(root, "FilesDemo3.out"));
        System.out.println(deleted);

        Files.copy(url.openStream(), Paths.get(root, "FilesDemo3.out"));
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Files.copy(Paths.get(root, "FilesDemo3.out"), out);

            System.out.println(out.toString("UTF-8").substring(0, 100) + "...");

            Files.copy(Paths.get(root, "FilesDemo3.out"), Paths.get(root, "FilesDemo4.out"));
            Files.move(Paths.get(root, "FilesDemo4.out"), Paths.get(root, "FilesDemo5.out"));
            Files.copy(Paths.get(root, "FilesDemo3.out"), Paths.get(root, "FilesDemo5.out"),
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES);
            Files.move(Paths.get(root, "FilesDemo5.out"), Paths.get(root, "FilesDemo6.out"),
                    StandardCopyOption.ATOMIC_MOVE);
            Files.deleteIfExists(Paths.get(root, "FilesDemo6.out"));

            Path newPath = Files.createTempFile(null, ".txt");
            System.out.println(newPath);
            newPath = Files.createTempDirectory("fred");
            System.out.println(newPath);
        }
    }
}

