package com.demo.test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UsersWriter {

    public static final int FROM_USER_COUNT = 106521;
    public static final int TO_USER_COUNT = 108621;

    public static void main(String[] args) throws IOException {
        String prefix = "perf_user_";
        Path path = Paths.get(".", "userlist.csv");

        for (int index = FROM_USER_COUNT; index <= TO_USER_COUNT; index+=20) {
            String content = prefix + String.valueOf(index) + "\n";
            System.out.print(content);
            Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
        }
    }
}
