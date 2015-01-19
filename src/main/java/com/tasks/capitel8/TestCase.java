package com.tasks.capitel8;

import java.lang.annotation.*;

/**
 * Date: 13.12.14
 */
@Repeatable(TestCases.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface TestCase {
    int params();

    int expectedExceptions();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TestCases {
    TestCase[] value();
}

