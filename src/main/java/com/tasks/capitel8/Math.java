package com.tasks.capitel8;

/**
 * Date: 13.12.14
 */
class Math {

    @TestCase(params = 4, expectedExceptions = 24)
    @TestCase(params = 0, expectedExceptions = 1)
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
