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
        File[] listOfFiles = file.listFiles(pathname -> true);
        if (listOfFiles != null)
        {
            for (File listOfFile : listOfFiles)
            {
                if (listOfFile.isDirectory())
                {
                    allDirectories(listOfFile.getPath());
                    System.out.printf("Directory: %s%n", listOfFile.getAbsolutePath());
                }
            }
        }
    }

    public static void allFiles(String path)
    {
        File file = new File(path);
        File[] listOfFiles = file.listFiles(pathname -> true);
//        Arrays.sort(listOfFiles, 0, listOfFiles.length);
        for (File listOfFile : listOfFiles)
        {
            if (listOfFile.isFile())
            {
                System.out.printf("File: %s%n", listOfFile.getName());
            } else
            {
                allFiles(listOfFile.getAbsolutePath());
            }
        }
    }


    public static void main(String[] args)
    {
        allDirectories(".");
        System.out.println("========================");
        allFiles(".");
    }
}
