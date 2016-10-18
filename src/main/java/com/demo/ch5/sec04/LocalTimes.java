package com.demo.ch5.sec04;

import java.time.*;

public class LocalTimes {
    public static void main(String[] args) {
        LocalTime rightNow = LocalTime.now();
        LocalTime bedtime = LocalTime.of(22, 30);
        bedtime = LocalTime.of(22, 30, 0);

        System.out.println("rightNow: " + rightNow);
        System.out.println("bedtime: " + bedtime);

        LocalTime wakeup = bedtime.plusHours(8); // wakeup is 6:30
        System.out.println("wakeup: " + wakeup);


        LocalTime low = LocalTime.of(8, 0);
        LocalTime high = LocalTime.of(17, 0);
        if (rightNow.isAfter(low) && rightNow.isBefore(high)) {
            System.out.println("it is a day");
        } else {
            System.out.println("it is a night");
        }
    }
}