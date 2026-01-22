package org.ragbag;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Thread t = new Thread(()->{
            System.out.println("Hello from another thread");
        });
        t.start();
    }
}