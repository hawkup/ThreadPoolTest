package com.example.threadpooltest;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

// https://www.baeldung.com/thread-pool-java-and-guava
// https://howtodoinjava.com/java/multi-threading/java-thread-pool-executor-example/
// https://coderstower.com/2021/04/05/java-concurrency-thread-pools-and-executors/

public class ThreadPoolTest {

    public static void bubbleSort(int arr[])
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(100);

        System.out.println("start loop");
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            long start = System.currentTimeMillis();
            executor.submit(() -> {
                System.out.println("Running: " + finalI + " Thread: " + Thread.currentThread().getName());

                int array[] = {101, 22, 133, 14, 5 , 20};
                bubbleSort(array);
                long end = System.currentTimeMillis();
                System.out.println("start: " + start + " end: " + end + " takes: " +
                        (end - start) + "ms");
            });
        }
    }
}
