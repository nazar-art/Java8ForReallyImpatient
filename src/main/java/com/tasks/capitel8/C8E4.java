package com.tasks.capitel8;

import com.tasks.Exercise;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * The Math.nextDown(x) method returns the next smaller floating-point number
 * than x, just in case some random process hit x exactly, and we promised a
 * number < x. Can this really happen? Consider double r = 1 - generator.
 * nextDouble(), where generator is an instance of java.util.Random. Can it ever yield
 * 1? That is, can generator.nextDouble() ever yield 0? The documentation says it
 * can yield any value between 0 inclusive and 1 exclusive. But, given that there
 * are 253 such floating-point numbers, will you ever get a zero? Indeed, you
 * do. The random number generator computes the next seed as next(s) = s · m
 * + a % N, where m = 25214903917, a = 11, and N = 248. The inverse of m modulo
 * N is v = 246154705703781, and therefore you can compute the predecessor of
 * a seed as prev(s) = (s – a) · v % N. To make a double, two random numbers are
 * generated, and the top 26 and 27 bits are taken each time. When s is 0, next(s)
 * is 11, so that’s what we want to hit: two consecutive numbers whose top bits
 * are zero. Now, working backwards, let’s start with s = prev(prev(prev(0))).
 * Since the Random constructor sets s = (initialSeed ^ m) % N, offer it s =
 * prev(prev(prev(0))) ^ m = 164311266871034, and you’ll get a zero after two
 * calls to nextDouble. But that is still too obvious. Generate a million predecessors,
 * using a stream of course, and pick the minimum seed. Hint: You will get a
 * zero after 376050 calls to nextDouble.
 */
public class C8E4 implements Exercise {

    final long m = 25214903917L;
    final long v = 246154705703781L;
    final long a = 11;
    final long n = 281474976710656L;

    @Test
    @Override
    public void perform() {
        long seed = Stream.iterate(prev(0), this::prev)
                .limit(1_000_000).min((x, y) ->
                        Long.compare(x ^ m, y ^ m)).get();
        Random generator = new Random(seed ^ m);
        long index = 0;
        double d;
        do {
            index++;
            d = generator.nextDouble();
        } while (d != 0);
        assertEquals(376050, index);
    }


    long prev(long s) {
        return (BigInteger.valueOf(s).subtract(BigInteger.valueOf(a)))
                .multiply(BigInteger.valueOf(v))
                .mod(BigInteger.valueOf(n)).longValue();
    }

}
