package com.demo.ch5.sec02;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDates {
    public static void main(String[] args) {
        /*DateFormat dateFormat = new SimpleDateFormat("dd");
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, 1);
        System.out.println("date should be: " + dateFormat.format(date));*/
        //

        LocalDate lastAprilDay = LocalDate.of(2014, Month.APRIL, 30);
        System.out.println("last april day: " + lastAprilDay);
        LocalDate firstMay = lastAprilDay.plusDays(1);
        System.out.println("should be first may day: " + firstMay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        String formatDate = formatter.format(firstMay);
        System.out.println("formatted date: " + formatDate);

        //
        LocalDate today = LocalDate.now(); // Today’s date
        System.out.println("today: " + today);

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
//        System.out.println("Difference with Duration: " + Duration.between(independenceDay.atTime(0, 0),

        System.out.println("Difference with ChronUnits: " +
        ChronoUnit.DAYS.between(independenceDay, christmas));

        System.out.println(LocalDate.of(2016, 1, 31).plusMonths(1));
        System.out.println(LocalDate.of(2016, 3, 31).minusMonths(1));

        DayOfWeek startOfLastMillennium = LocalDate.of(1900, 1, 1).getDayOfWeek();
        System.out.println("startOfLastMillennium: " + startOfLastMillennium);
        System.out.println(startOfLastMillennium.getValue());
        System.out.println(DayOfWeek.SATURDAY.plus(3));
    }
}

