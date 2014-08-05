package com.demo.ch2;

public class ProcessorsCounter {
    public static void main(String[] args) {
        System.out.println("number of cores: "+Runtime.getRuntime().availableProcessors());
    }
}
