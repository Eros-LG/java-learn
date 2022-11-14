package org.example.test1;

public class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId() + ", " + Thread.currentThread().getName());
    }
}
