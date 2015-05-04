package com.demo.ch9.sec02;

import java.nio.file.*;

/**
 * @author Nazar_Lelyak.
 */
public class PathDemo {
    public static void main(String[] args) {
        Path absolute = Paths.get("/", "home", "nazar");
        System.out.println(absolute);
        Path relative = Paths.get("myprog", "conf", "user.properties");
        System.out.println(relative);
        Path homeDirectory = Paths.get("/home/nazar");
        System.out.println(homeDirectory);
        Path configPath = homeDirectory.resolve("myprog/conf/user.properties");
        System.out.println(configPath);
        Path workPath = Paths.get("/home/nazar/myprog/work");
        Path tempPath = workPath.resolveSibling("temp");
        System.out.println(tempPath);

        System.out.println(Paths.get("/home/nazar").relativize(Paths.get("/home/fred/myprog")));
        System.out.println(Paths.get("/home/nazar/../fred/./myprog").normalize());

        Path p = Paths.get("/home", "nazar", "myprog.properties");
        Path parent = p.getParent(); // the path /home/nazar
        System.out.println(parent);
        Path file = p.getFileName(); // the path myprog.properties
        System.out.println(file);
        Path root = p.getRoot(); // the path /
        System.out.println(root);
        System.out.println(file.getRoot());
    }
}

