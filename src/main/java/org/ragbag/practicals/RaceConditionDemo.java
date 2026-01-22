package org.ragbag.practicals;

public class RaceConditionDemo {

    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> increment("Thread 1"));
        Thread t2 = new Thread(() -> increment("Thread 2"));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final counter: " + counter);
    }

    static void increment(String name) {
        for (int i = 0; i < 1000; i++) {
            counter++; // NOT atomic!
        }
        System.out.println(name + " finished");
    }
}
