package com.tasks.capitel8;

import com.tasks.Exercise;
import org.junit.Test;

import static java.lang.Math.floorMod;
import static java.lang.StrictMath.abs;
import static org.junit.Assert.*;

/**
 * Euclid’s algorithm (which is over two thousand years old) computes the
 * greatest common divisor of two numbers as gcd(a, b) = a if b is zero, and
 * gcd(b, rem(a, b)) otherwise, where rem is the remainder. Clearly, the gcd
 * should not be negative, even if a or b are (since its negation would then be a
 * greater divisor). Implement the algorithm with %, floorMod, and a rem function
 * that produces the mathematical (non-negative) remainder. Which of the three
 * gives you the least hassle with negative values?
 */
public class C8E3 implements Exercise {

    @Test
    @Override
    public void perform() {
        assertEquals(21, gcdMod(1071, 1029));
        assertEquals(21, gcdMod(1071, -1029));
        assertEquals(21, gcdMod(-1071, 1029));
        assertEquals(21, gcdMod(-1071, -1029));
        assertEquals(21, gcdFloorMod(1071, 1029));
        assertEquals(21, gcdFloorMod(1071, -1029));
        assertEquals(21, gcdFloorMod(-1071, 1029));
        assertEquals(21, gcdFloorMod(-1071, -1029));
        assertEquals(21, gcdMath(1071, 1029));
        assertEquals(21, gcdMath(1071, -1029));
        assertEquals(21, gcdMath(-1071, 1029));
        assertEquals(21, gcdMath(-1071, -1029));
    }

    public int gcdMod(int a, int b) {
        if (b == 0) return a;
        return gcdMod(b, (a % b + abs(b)) % abs(b));
    }

    public int gcdFloorMod(int a, int b) {
        if (b == 0) return a;
        return gcdFloorMod(b, (floorMod(a, b) + abs(b)) % abs(b));
    }

    public int gcdMath(int a, int b) {
        if (b == 0) return a;
        return gcdMath(b, rem(a, b));
    }

    public int rem(int a, int b) {
        int r = a;
        if (b < 0) return rem(a, -b);
        if (a < 0) {
            r = rem(-a, b);
            if (r == 0) return 0;
            else return b - r;
        }
        while (r >= b) {
            r = r - b;
        }
        return r;
    }
}
