package com.tasks.capitel5;

import com.tasks.Exercise;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * Date: 24.11.14
 */
public class C5E5 implements Exercise {

    @Test
    @Override
    public void perform() {
        LocalDate birthday = LocalDate.of(1970, Month.JANUARY, 1);
        System.out.println(birthday.until(LocalDate.now(), ChronoUnit.DAYS));
    }
}
