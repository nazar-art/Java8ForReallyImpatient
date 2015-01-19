package com.tasks.capitel5;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.time.*;

import static org.testng.Assert.assertEquals;

/**
 * Date: 30.11.14
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
        Instant departuteInstant = ZonedDateTime.of(
                now,
                departure,
                departureZone
        ).toInstant();
        Instant arrivalInstant = ZonedDateTime.of(
                (arrival.isBefore(departure) || arrival.equals(departure)) ? now.plusDays(1) : now,
                arrival,
                arrivalZone
        ).toInstant();
        return Duration.between(departuteInstant, arrivalInstant);
    }
}
