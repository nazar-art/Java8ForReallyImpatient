package com.tasks.capitel8;

import com.tasks.Exercise;
import org.junit.Test;

/**
 * For which integer n does Math.negateExact(n) throw an exception? (Hint: There
 * is only one.)
 */
public class C8E2 implements Exercise {

    @Test(expected = Exception.class)
    @Override
    public void perform() {
        java.lang.Math.negateExact(Integer.MIN_VALUE);
    }
}
