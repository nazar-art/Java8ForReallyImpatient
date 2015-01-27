package com.tasks.capitel5;

import com.tasks.Exercise;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * Write a program that prints how many days you have been alive.
 */
public class C5E5 implements Exercise {

    @Test
    @Override
    public void perform() {
        LocalDate birthday = LocalDate.of(1988, Month.MARCH, 13);
        System.out.println(birthday.until(LocalDate.now(), ChronoUnit.DAYS));
    }
}
