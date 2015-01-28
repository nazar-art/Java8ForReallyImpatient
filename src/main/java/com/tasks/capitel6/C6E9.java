package com.tasks.capitel6;

import com.tasks.Exercise;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * You can use the parallelPrefix method to parallelize the computation of Fibonacci
 * numbers. We use the fact that the nth Fibonacci number is the top
 * left coefficient of Fn, where F = ( 1
 * 1
 * 1
 * 0 ) . Make an array filled with 2 × 2 matrices.
 * Define a Matrix class with a multiplication method, use parallelSetAll to
 * make an array of matrices, and use parallelPrefix to multiply them.
 */
public class C6E9 implements Exercise {

    class Matrix {

        int[][] m;

        Matrix(int[][] m) {
            this.m = m;
        }

        Matrix multiply(Matrix other) {
            int x1 = m[0][0] * other.m[0][0] + m[0][1] * other.m[1][0];
            int y1 = m[0][0] * other.m[0][1] + m[0][1] * other.m[1][1];
            int x2 = m[1][0] * other.m[0][0] + m[1][1] * other.m[1][0];
            int y2 = m[1][0] * other.m[0][1] + m[1][1] * other.m[1][1];
            return new Matrix(new int[][]{{x1, y1}, {x2, y2}});
        }
    }

    @Test
    @Override
    public void perform() {
        Matrix[] array = new Matrix[10];
        final int[][] f = {{1, 1}, {1, 0}};
        Arrays.parallelSetAll(array, i -> new Matrix(f));
        Arrays.parallelPrefix(array, (m1, m2) -> m1.multiply(m2));

        assertEquals(1, array[0].m[0][0]);
        assertEquals(2, array[1].m[0][0]);
        assertEquals(3, array[2].m[0][0]);
        assertEquals(5, array[3].m[0][0]);
        assertEquals(8, array[4].m[0][0]);
        assertEquals(13, array[5].m[0][0]);
        assertEquals(21, array[6].m[0][0]);
        assertEquals(34, array[7].m[0][0]);
        assertEquals(55, array[8].m[0][0]);
        assertEquals(89, array[9].m[0][0]);
    }

}
