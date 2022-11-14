package org.example.test2;

import java.util.Date;

public class MyRunnable implements Runnable{
    private String message;

    public MyRunnable(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " [Start]. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " [End]. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
