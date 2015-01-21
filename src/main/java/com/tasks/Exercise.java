package com.tasks;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public interface Exercise {

    public String WORDS_SPLITTER = "[\\P{L}]+";
    public String ALICE_FILE = "/alice.txt";
    public String WAR_AND_PEACE_FILE = "/war-and-peace.txt";

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

    default List<String> getWordsAsListForPeace() {
        String content;
        try {
            content = new String(Files.readAllBytes(
                    Paths.get(this.getClass().getResource(WAR_AND_PEACE_FILE).toURI())),
                    StandardCharsets.UTF_8);
            return Arrays.asList(content.split(WORDS_SPLITTER));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
