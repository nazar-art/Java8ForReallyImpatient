package com.demo.ch5.sec02;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class LocalDates {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now(); // Today’s date
        System.out.println("TODAY: " + today);

        /*String strDate = today.plusWeeks(1).toString(); // 2015-09-01
        String day;
        if (strDate.substring(8, 9).matches("0")) {
            day = strDate.substring(9);
            System.out.println("DAY IS: " + day);
        } else {
            day = strDate.substring(8);
            System.out.println("DAY IS: " + day);
        }*/

        int dayOfMonth = today.plusDays(4).getDayOfMonth();
        System.out.println("DAY OF MONTH: " + dayOfMonth);

        LocalDate localDate = LocalDate.of(2015, Month.valueOf("OCTOBER"), 25);
        System.out.println("LOCAL DATE: " + localDate);

        long toDays = Duration.between(localDate.atTime(0, 0), today.atTime(0, 0)).toDays();
        System.out.println("TO DAYS: " + toDays);
        Duration toDays23 = Duration.between(localDate, today);
        System.out.println("TO DAYS: " + toDays23);

        Month month = today.getMonth();
//        localDate.
        System.out.println("Month " + month.toString());
        String displayName = month.getDisplayName(TextStyle.FULL, Locale.CANADA);
        System.out.println("DISPLAY NAME: " + displayName);

        LocalDate alonzosBirthday = LocalDate.of(1903, 6, 14);
        alonzosBirthday = LocalDate.of(1903, Month.JUNE, 14);
        // Uses the Month enumeration
        System.out.println("alonzosBirthday: " + alonzosBirthday);

        LocalDate programmersDay = LocalDate.of(2015, 1, 1).plusDays(255);
        // September 13, but in a leap year it would be September 12
        System.out.println("programmersDay: " + programmersDay);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        LocalDate christmas = LocalDate.of(2014, Month.DECEMBER, 25);

        System.out.println("Until christmas: " + independenceDay.until(christmas));
        System.out.println("Until christmas (with crono): " + independenceDay.until(christmas, ChronoUnit.DAYS));

        System.out.println(LocalDate.of(2016, 1, 31).plusMonths(1));
        System.out.println(LocalDate.of(2016, 3, 31).minusMonths(1));

        DayOfWeek startOfLastMillennium = LocalDate.of(1900, 1, 1).getDayOfWeek();
        System.out.println("startOfLastMillennium: " + startOfLastMillennium);
        System.out.println(startOfLastMillennium.getValue());
        System.out.println(DayOfWeek.SATURDAY.plus(3));
    }
}

