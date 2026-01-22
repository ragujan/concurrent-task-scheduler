package org.ragbag.practicals;

public class DownloadExample {
    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                System.out.println("Listening for user input...");
                sleep(1000);
            }
        }).start();

        new Thread(() -> {
            System.out.println("Downloading file...");
            sleep(5000);
            System.out.println("Download complete");
        }).start();
    }

    static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
