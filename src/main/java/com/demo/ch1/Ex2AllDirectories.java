package com.demo.ch1;


import java.io.File;

/**
 * Using the listFiles(FileFilter) and isDirectory methods of the java.io.File class,
 * write a method that returns all subdirectories of a given directory.
 * Use a lambda expression instead of a FileFilter object.
 * Repeat with a method expression
 */
public class Ex2AllDirectories {

    public static void allDirectories(String path)
    {
        File file = new File(path);
        if (!file.listFiles())
        /*{

        }*/
    }

    public static void main(String[] args)
    {
        String path = ".";

    }
}
