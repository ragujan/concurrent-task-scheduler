package org.ragbag.practicals;

public class ThreadPracticals {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        task("Task 1");
        task("Task 2");

        long end = System.currentTimeMillis();
        System.out.println("Total time: " + (end - start) + " ms");
    }

    static void task(String name){
        System.out.println("Task "+name+" started");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task "+name+" ended");
    }
}
