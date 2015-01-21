package com.tasks.capitel5;

import com.tasks.Exercise;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Date: 23.11.14
 */
public class C5E2 implements Exercise {

    @Test
    @Override
    public void perform() {
        LocalDate date = LocalDate.of(2000, 2, 29);
        System.out.println(date.plusYears(1));
        System.out.println(date.plusYears(4));
        System.out.println(date.plusYears(1).plusYears(1).plusYears(1).plusYears(1));
    }
}
