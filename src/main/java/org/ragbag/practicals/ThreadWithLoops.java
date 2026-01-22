package org.ragbag.practicals;

public class ThreadWithLoops {

    public static void main(String[] args) throws InterruptedException {

        long start = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 15; i++) {
                doWork("first loop " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 15; i++) {
                doWork("second loop " + i);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        for (int i = 0; i <= 15; i++) {
            System.out.println("Task from main thread" + i + " started");
            Thread.sleep(2000);
        }

        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start) + " ms");
    }

    static void doWork(String i) {
        System.out.println("Task " + i + " started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task " + i + " finished");
    }
}
