package com.tasks.capitel5;

import com.tasks.Exercise;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * List all Friday the 13th in the twentieth century.
 */
public class C5E6 implements Exercise {

    @Test
    @Override
    public void perform() {
        LocalDate date = LocalDate.of(2000, 1, 1).with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        LocalDate millennium = LocalDate.of(2016, 1, 1);
        while (date.isBefore(millennium)) {
            if (date.getDayOfMonth() == 13) {
                System.out.println(date.format(DateTimeFormatter.ofPattern("E dd MM yyyy")));
            }
            date = date.plusWeeks(1);
        }
    }
}
