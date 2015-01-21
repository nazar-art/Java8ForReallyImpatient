package com.tasks.capitel8;

import com.tasks.Exercise;
import org.junit.Test;

/**
 * Date: 06.12.14
 */
public class C8E2 implements Exercise {

    @Test(expected = Exception.class)
    @Override
    public void perform() {
        java.lang.Math.negateExact(Integer.MIN_VALUE);
    }
}
