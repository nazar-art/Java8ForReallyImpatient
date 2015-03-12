package com.utils;

public class StopWatch {

    private long elapsedTime;
    private long startTime;
    private boolean isRunning;

    public void start() {
        if (isRunning) return;
        isRunning = true;
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        if (!isRunning) return;
        isRunning = false;
        long endTime = System.currentTimeMillis();
        elapsedTime = elapsedTime + endTime - startTime;
    }

    public long getElapsedTime() {
        if (isRunning) {
            long endTime = System.currentTimeMillis();
            return elapsedTime + endTime - startTime;
        } else
            return elapsedTime;
    }

    public long getElapsedTimeInSeconds() {
        if (isRunning) {
            long endTime = System.currentTimeMillis();
            return (elapsedTime + endTime - startTime) / 1_000;
        } else
            return elapsedTime / 1_000;
    }

    public void reset() {
        elapsedTime = 0;
        isRunning = false;
    }
}
