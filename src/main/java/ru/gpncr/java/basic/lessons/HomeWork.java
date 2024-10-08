package ru.gpncr.java.basic.lessons;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeWork {
    private static final Object lock = new Object();
    private static char currentChar = 'A';
    private static final int COUNT = 5;

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Thread printA = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                synchronized (lock) {
                    while (currentChar != 'A') {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print("A");
                    currentChar = 'B';
                    lock.notifyAll();
                }
            }
        });


        Thread printB = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                synchronized (lock) {
                    while (currentChar != 'B') {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print("B");
                    currentChar = 'C';
                    lock.notifyAll();
                }
            }
        });


        Thread printC = new Thread(() -> {
            for (int i = 0; i < COUNT; i++) {
                synchronized (lock) {
                    while (currentChar != 'C') {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print("C");
                    currentChar = 'A';
                    lock.notifyAll();
                }
            }
        });


        executor.execute(printA);
        executor.execute(printB);
        executor.execute(printC);

        executor.shutdown();
    }

}