package com.tasks.capitel2;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Write a call to reduce that can be used to compute the average of a Stream<Double>.
 * Why can’t you simply compute the sum and divide by count()?
 */
public class C2E10 implements Exercise {

    @Test
    @Override
    public void perform() {
        assertEquals(5.0, average(Stream.of(2.0, 4.0, 6.0, 8.0)), 0.1);
        assertEquals(5.0, average(Stream.of(2.0, 4.0, 6.0, 8.0).parallel()), 0.1);
    }

    public double average(Stream<Double> stream) {
        return stream.reduce(
                new Averager(), Averager::accept, Averager::combine
        ).average();
    }
}

class Averager {

    final long count;
    final Double value;

    Averager() {
        this.count = 0;
        this.value = 0.0;
    }

    Averager(long count, Double value) {
        this.count = count;
        this.value = value;
    }

    Averager accept(Double value) {
        return new Averager(this.count + 1, this.value + value);
    }

    Averager combine(Averager averager) {
        return new Averager(this.count + averager.count, this.value + averager.value);
    }

    double average() {
        return value / count;
    }

}
