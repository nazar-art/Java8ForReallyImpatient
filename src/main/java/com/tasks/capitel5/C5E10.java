package com.tasks.capitel5;

import com.tasks.Exercise;
import org.junit.Test;

import java.time.*;

import static org.junit.Assert.*;

/**
 * Your flight from Los Angeles to Frankfurt leaves at 3:05 pm local time and
 * takes 10 hours and 50 minutes. When does it arrive? Write a program that
 * can handle calculations like this.
 */
public class C5E10 implements Exercise {

    @Test
    @Override
    public void perform() {
        LocalTime arrival = getArrivalTime(
                LocalTime.of(15, 5),
                ZoneId.of("America/Los_Angeles"),
                Duration.ofMinutes(10 * 60 + 50),
                ZoneId.of("Europe/Paris")
        );
        assertEquals(10, arrival.getHour());
        assertEquals(55, arrival.getMinute());
    }

    public LocalTime getArrivalTime(LocalTime departure,
                                    ZoneId location,
                                    Duration duration,
                                    ZoneId destination) {
        ZonedDateTime departureDateTime = ZonedDateTime.of(
                LocalDate.now(),
                departure,
                location
        );
        ZonedDateTime arrivalDateTime = departureDateTime.plus(duration);
        return arrivalDateTime.withZoneSameInstant(destination).toLocalTime();
    }
}
