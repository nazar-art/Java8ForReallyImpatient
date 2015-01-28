package com.tasks.capitel6;

import com.tasks.Exercise;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

/**
 * Repeat the preceding exercise, but use computeIfAbsent instead. What is the
 * advantage of this approach?
 */
public class C6E6 implements Exercise {

    @Test
    @Override
    public void perform() {
        ConcurrentHashMap<String, Set<File>> map = new ConcurrentHashMap<>();
        File[] files = {
                new File(this.getClass().getResource("/txt/alice.txt").getFile()),
                new File(this.getClass().getResource("/fxml/person.fxml").getFile()),
        };

        Arrays.asList(files).parallelStream().forEach(f -> {
            try {
                Arrays.asList(new String(Files.readAllBytes(f.toPath()), StandardCharsets.UTF_8)
                        .split("[\\P{L}]+")).stream().forEach(w ->
                        map.computeIfAbsent(w, k -> new HashSet<>()).add(f));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        assertNotNull(map.get("name"));
        assertEquals(2, map.get("name").size());
    }
}
