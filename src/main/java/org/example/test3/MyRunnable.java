package org.example.test3;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

public class MyRunnable implements Callable<Integer> {
    public static AtomicInteger id = new AtomicInteger(1001);
    private String message;

    public MyRunnable(String message) {
        this.message = message;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " [Start]. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " [End]. Time = " + new Date());

        return id.getAndAdd(1);
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
