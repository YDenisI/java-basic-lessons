package ru.gpncr.java.basic.lessons;

public class HomeWork {

    private static final int ARRAY_SIZE = 100_000_000;
    private static final int COUNT_THREAD = 4;

    public static void main(String[] args) {
        System.out.println("HomeWork");

        System.out.println("Время заполнения массива одним потоком: " + SingleThread() + " секунд");
        System.out.println("Время заполнения массива 4 потоками: " + MultiThread() + " секунд");

    }

    private static double SingleThread() {
        long startTime = System.nanoTime();
        double[] array = new double[ARRAY_SIZE];
        for (int i = 0; i < ARRAY_SIZE; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000_000.0; // Возвращаем время в секундах
    }
 
    private static double MultiThread() {
        long startTime = System.nanoTime();
        double[] array = new double[ARRAY_SIZE];
        Thread[] threads = new Thread[COUNT_THREAD];

        for (int t = 0; t < COUNT_THREAD; t++) {
            int threadIndex = t;

            threads[t] = new Thread(() -> {
                int start = (ARRAY_SIZE / COUNT_THREAD) * threadIndex;
                int end = (ARRAY_SIZE / COUNT_THREAD) * (threadIndex + 1);

                for (int i = start; i < end; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            });

            threads[t].start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000_000.0; // Возвращаем время в секундах


    }
}
