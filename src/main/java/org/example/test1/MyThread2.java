package org.example.test1;

public class MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + ", " + Thread.currentThread().getName());
    }
}
