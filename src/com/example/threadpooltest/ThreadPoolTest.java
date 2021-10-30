package com.example.threadpooltest;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);


        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis();
            executor.execute(() -> {
                System.out.println("Hello World");
                long end = System.currentTimeMillis();
                System.out.println("start: " + start + " end: " + end + " takes: " +
                        (end - start) + "ms");
            });
        }
    }
}
