package com.tasks.capitel8;

import com.tasks.Exercise;
import org.junit.Test;

import java.lang.reflect.Method;

import static junit.framework.TestCase.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Implement the TestCase annotation and a program that loads a class with such
 * annotations and invokes the annotated methods, checking whether they yield
 * the expected values. Assume that parameters and return values are integers.
 */
public class C8E12 implements Exercise {

    @Test
    @Override
    public void perform() {
        Class clazz = java.lang.Math.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            TestCase[] testCases = method.getAnnotationsByType(TestCase.class);
            assertTrue(testCases.length > 0);
            for (TestCase testCase : testCases) {
                assertEquals(testCase.expectedExceptions(), Math.factorial(testCase.params()));
            }
        }
    }

}

