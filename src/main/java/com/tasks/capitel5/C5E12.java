package com.tasks.capitel5;

import com.tasks.Exercise;
import org.junit.Test;

import java.time.*;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Write a program that solves the problem described at the beginning of
 * Section 5.5, “Zoned Time,” on page 109. Read a set of appointments in different
 * time zones and alert the user which ones are due within the next hour in
 * local time.
 */
public class C5E12 implements Exercise {

    @Test
    @Override
    public void perform() {
        assertFalse(alert(
                LocalTime.of(0, 40), ZoneId.of("America/Los_Angeles"),
                LocalTime.of(9, 50), ZoneId.of("Europe/Paris")));
        assertTrue(alert(
                LocalTime.of(1, 40), ZoneId.of("America/Los_Angeles"),
                LocalTime.of(9, 50), ZoneId.of("Europe/Paris")));
        assertFalse(alert(
                LocalTime.of(2, 40), ZoneId.of("America/Los_Angeles"),
                LocalTime.of(9, 50), ZoneId.of("Europe/Paris")));
    }

    public boolean alert(LocalTime appointmentTime,
                         ZoneId appointmentZone,
                         LocalTime localTime,
                         ZoneId localZone) {
        ZonedDateTime appointment = ZonedDateTime.of(
                LocalDate.now(),
                appointmentTime,
                appointmentZone
        );
        long duration = Duration.between(
                ZonedDateTime.of(LocalDate.now(), localTime, localZone).toInstant(),
                appointment.withZoneSameInstant(localZone).toInstant())
                .toMinutes();
        return 0 < duration && duration < 60;

    }
}
