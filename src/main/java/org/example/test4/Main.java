package org.example.test4;

import org.example.test4.utils.DateUtils;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        String date = DateUtils.dateFormatThreadLocal.get().format(new Date());
        System.out.println(date);

        for (int i = 0; i < 5; ++i) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " " + System.identityHashCode(DateUtils.dateFormatThreadLocal.get()) );
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
