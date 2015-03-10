package com.tasks.capitel9;

import com.demo.ch2.Test;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Implement a code segment that constructs a Scanner and a PrintWriter at the
 * end of Section 9.1.1, “The try-with-resources Statement,” on page 180, without
 * the try-with-resources statement. Be sure to close both objects, provided they
 * have been properly constructed. You need to consider the following
 * conditions:
 * • The Scanner constructor throws an exception.
 * • The PrintWriter constructor throws an exception.
 * • hasNext, next, or println throws an exception.
 * • in.close() throws an exception.
 * • out.close() throws an exception.
 */
public class C9E1 {
    private static long count = 1;

    public static void main(String[] args) {
        try {
            perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void perform() throws Exception {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get(Test.ALICE_PATH));
            try {
                out = new PrintWriter(System.out);
                while (in.hasNext()) {
                    out.println(count++ + " " + in.next().toLowerCase());
                }
            } finally {
                if (null != out) {
                    out.close();
                }
            }
        } finally {
            if (null != in) {
                in.close();
            }
        }
    }
}
