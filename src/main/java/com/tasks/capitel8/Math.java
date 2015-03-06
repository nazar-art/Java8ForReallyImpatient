package com.tasks.capitel8;

class Math {

    @TestCase(params = 4, expectedExceptions = 24)
    @TestCase(params = 0, expectedExceptions = 1)
    public static int factorial(int n) {
        int fact = 1;
        for (int index = 1; index <= n; index++) {
            fact *= index;
        }
        return fact;
    }
}
