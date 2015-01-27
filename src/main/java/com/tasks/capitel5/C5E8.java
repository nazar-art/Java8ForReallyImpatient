package com.tasks.capitel5;

import com.tasks.Exercise;
import org.junit.Test;

import java.time.Instant;
import java.time.ZoneId;

/**
 * Obtain the offsets of today’s date in all supported time zones for the current
 * time instant, turning ZoneId.getAvailableIds into a stream and using stream
 * operations.
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
