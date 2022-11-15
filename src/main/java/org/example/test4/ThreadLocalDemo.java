package org.example.test4;

public class ThreadLocalDemo {
    private static ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
           ThreadLocalDemo.stringThreadLocal.set("local_A");
            System.out.println(Thread.currentThread().getName() + " : " + stringThreadLocal.get());
        },"Thread-A").start();

        Thread.sleep(1000);

        new Thread(()->{
            ThreadLocalDemo.stringThreadLocal.set("local_B");
            System.out.println(Thread.currentThread().getName() + " : " + stringThreadLocal.get());

            ThreadLocalDemo.stringThreadLocal.set("local_B2");
            System.out.println(Thread.currentThread().getName() + " : " + stringThreadLocal.get());
        },"Thread-B").start();

    }
}
