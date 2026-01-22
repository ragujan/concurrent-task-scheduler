package org.ragbag.practicals;

public class MainFinishesEarly {
    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Worker running " + i);
                sleep(1000);
            }
        }).start();

        System.out.println("Main finished");
    }

    static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {}
    }
}
