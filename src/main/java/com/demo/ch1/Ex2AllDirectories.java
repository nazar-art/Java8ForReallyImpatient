package com.demo.ch1;


import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Using the listFiles(FileFilter) and isDirectory methods of the java.io.File class,
 * write a method that returns all subdirectories of a given directory.
 * Use a lambda expression instead of a FileFilter object.
 * Repeat with a method expression
 */
public class Ex2AllDirectories {

    public static void allDirectories(File file) {
        File[] listOfFiles = file.listFiles(pathname -> true);
        if (listOfFiles != null) {
            for (File listOfFile : listOfFiles) {
                if (listOfFile.isDirectory()) {
                    allDirectories(listOfFile);
                    System.out.printf("Directory: %s%n", listOfFile.getAbsolutePath());
                }
            }
        }
    }

    public static void allFiles(File file) {
        File[] listOfFiles = file.listFiles(pathname -> true);
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                System.out.printf("File: %s%n", listOfFile.getName());
            } else {
                allFiles(listOfFile);
            }
        }
    }

    /**
     * Given an array of File objects, sort it so that the directories come before the files,
     * and within each group, elements are sorted by path name.
     * Use a lambda expression, not a Comparator
     *
     * @param file start file object
     */
    public static void sortDirectoryContent(File file) {
        File[] files = file.listFiles();
        Arrays.sort(files, Comparator.comparing(File::isDirectory));
        Arrays.toString(files);
    }

    public static void main(String[] args) {
//        allDirectories(new File("."));
        System.out.println("========================");
//        allFiles(new File("."));
        System.out.println("========================");
        sortDirectoryContent(new File("."));
    }
}
