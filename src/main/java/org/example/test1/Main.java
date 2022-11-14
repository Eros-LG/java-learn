package org.example.test1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
/**
 * 线程创建的三种方式
 */
public class Main {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getId() + ", " + Thread.currentThread().getName());

        Thread thread1 = new MyThread("Thread-1");
        Thread thread2 = new Thread(new MyThread2(), "Thread-2");

        MyThread3 mt = new MyThread3();
        FutureTask<String> futureTask = new FutureTask<>(mt);
        Thread thread3 = new Thread(futureTask, "Thread-3");
        thread3.start();

        thread1.start();
        thread2.start();

        try {
            String o = futureTask.get();
            System.out.println("futuretask: " + o);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
