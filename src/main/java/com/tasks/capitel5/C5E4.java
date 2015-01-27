package com.tasks.capitel5;

import com.tasks.Exercise;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Write an equivalent of the Unix cal program that displays a calendar for a
 * month. For example, java Cal 3 2013 should display
 *         1 2  3
 * 4 5 6 7 8 9 10
 * 11 12 13 14 15 16 17
 * 18 19 20 21 22 23 24
 * 25 26 27 28 29 30 31
 * indicating that March 1 is a Friday. (Show the weekend at the end of
 * the week.)
 */
public class C5E4 implements Exercise {

    @Test
    @Override
    public void perform() {
        print(2, 2015);
    }

    public void print(int month, int year) {
        LocalDate day = LocalDate.of(year, month, 1);
        if (day.getDayOfWeek() != DayOfWeek.MONDAY) {
            day = day.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        }
        while (day.getMonth().getValue() < month + 1) {
            System.out.print(getDay(day, month));
            if (day.getDayOfWeek() == DayOfWeek.SUNDAY
                    && day.plusDays(1).getMonth().getValue() < month + 1) {
                System.out.println("");
            }
            day = day.plusDays(1);
        }
    }

    private String getDay(LocalDate date, int month) {
        if (date.getMonth().getValue() != month) {
            return "    ";
        }
        return date.getDayOfMonth() < 10
                ? "   " + date.getDayOfMonth()
                : "  " + date.getDayOfMonth();
    }
}
