package com.tasks.capitel5;

import com.tasks.Exercise;
import org.junit.Test;

import java.time.*;

import static org.junit.Assert.*;

/**
 * Your return flight leaves Frankfurt at 14:05 and arrives in Los Angeles at
 * 16:40. How long is the flight? Write a program that can handle calculations
 * like this.
 */
public class C5E11 implements Exercise {

    @Test
    @Override
    public void perform() {
        Duration duration = getDuration(
                LocalTime.of(14, 5),
                ZoneId.of("Europe/Paris"),
                LocalTime.of(16, 40),
                ZoneId.of("America/Los_Angeles")
        );
        assertEquals(11, duration.toHours());
        assertEquals(35, duration.toMinutes() % 60);
    }

    public Duration getDuration(LocalTime departure,
                                ZoneId departureZone,
                                LocalTime arrival,
                                ZoneId arrivalZone) {
        LocalDate now = LocalDate.now();
        Instant departureInstant = ZonedDateTime.of(
                now,
                departure,
                departureZone
        ).toInstant();
        Instant arrivalInstant = ZonedDateTime.of(
                (arrival.isBefore(departure) || arrival.equals(departure)) ? now.plusDays(1) : now,
                arrival,
                arrivalZone
        ).toInstant();
        return Duration.between(departureInstant, arrivalInstant);
    }
}
