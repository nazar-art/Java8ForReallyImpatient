package com.tasks;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * Date: 27.10.14
 */
public interface Exercise {

    String WORDS_SPLITTER = "[\\P{L}]+";
    String ALICE_FILE = "/alice.txt";

    void perform();

    default List<String> getWordsAsList() {
        String content;
        try {
            content = new String(Files.readAllBytes(
                    Paths.get(this.getClass().getResource(ALICE_FILE).toURI())),
                    StandardCharsets.UTF_8);
            return Arrays.asList(content.split(WORDS_SPLITTER));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    default String[] getWordsAsArray() {
        String content;
        try {
            content = new String(Files.readAllBytes(
                    Paths.get(this.getClass().getResource(ALICE_FILE).toURI())),
                    StandardCharsets.UTF_8);
            return content.split(WORDS_SPLITTER);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
