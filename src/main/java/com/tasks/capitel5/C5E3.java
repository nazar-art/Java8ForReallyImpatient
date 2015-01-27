package com.tasks.capitel5;

import com.tasks.Exercise;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Implement a method next that takes a Predicate<LocalDate> and returns an
 * adjuster yielding the next date fulfilling the predicate. For example,
 * today.with(next(w -> getDayOfWeek().getValue() < 6))
 * computes the next workday.
 */
public class C5E3 implements Exercise {

    @Test
    @Override
    public void perform() {
        LocalDate date = LocalDate.of(2014, Month.NOVEMBER, 22);
        LocalDate nextWorkday = date.with(next(w -> w.getDayOfWeek().getValue() < 6));
        assertEquals(24, nextWorkday.getDayOfMonth());
        assertEquals(Month.NOVEMBER, nextWorkday.getMonth());
    }

    public TemporalAdjuster next(Predicate<LocalDate> predicate) {
        return TemporalAdjusters.ofDateAdjuster(temporal -> {
            LocalDate date = temporal;
            do {
                date = date.plusDays(1);
            } while (!predicate.test(date));
            return date;
        });
    }
}
