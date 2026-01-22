package org.ragbag.practicals;

public class ParallelismTimelineDemo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Demo started on thread: " + Thread.currentThread().getName());

        int numThreads = 4;  // number of tasks
        int steps = 5;       // steps per thread
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            final int threadId = i;
            threads[i] = new Thread(() -> {
                for (int step = 0; step < steps; step++) {
                    System.out.println("Thread " + (threadId + 1) + ": " + printStep(step));
                    busyWork(); // simulate CPU-heavy work
                }
                System.out.println("Thread " + (threadId + 1) + " finished\n");
            });
        }

        // Start all threads
        for (Thread t : threads) t.start();

        // Wait for all threads to finish
        for (Thread t : threads) t.join();

        System.out.println("Demo finished");
    }

    // Simulate CPU-heavy work
    static void busyWork() {
        long sum = 0;
        for (int i = 0; i < 20_000_000; i++) sum += i;
    }

    // Visual representation of steps
    static String printStep(int step) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= step; i++) sb.append("█");
        return sb.toString();
    }
}
