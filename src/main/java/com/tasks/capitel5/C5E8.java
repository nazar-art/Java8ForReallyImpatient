package com.tasks.capitel5;

import com.tasks.Exercise;
import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;

/**
 * Date: 27.11.14
 */
public class C5E8 implements Exercise {

    @Test
    @Override
    public void perform() {
        Instant now = Instant.now();
        ZoneId.getAvailableZoneIds().stream()
                .map(id -> now.atZone(ZoneId.of(id)).getOffset())
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
