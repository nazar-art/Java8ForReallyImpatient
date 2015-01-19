package com.tasks.capitel5;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

import static org.testng.Assert.assertEquals;

/**
 * Date: 23.11.14
 */
public class C5E1 implements Exercise {

    @Test
    @Override
    public void perform() {
        LocalDate programmersDay = LocalDate.of(2014, Month.JANUARY, 1).plus(Period.ofDays(255));
        assertEquals(13, programmersDay.getDayOfMonth());
        assertEquals(Month.SEPTEMBER, programmersDay.getMonth());
    }
}
