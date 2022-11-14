package org.example.test3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 使用线程池带返回值
 */
public class Main {
    private static final int CORE_POOL_SIZE = 5;
    private static final int MAXIMUM_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAXIMUM_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                new ThreadPoolExecutor.CallerRunsPolicy());

        List<Future<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            MyRunnable worker = new MyRunnable("" + i);
            Future<Integer> future = executor.submit(worker);
            futureList.add(future);
        }
        for (Future<Integer> future : futureList) {
            Integer integer = future.get();
            System.out.println(integer);
        }
        executor.shutdown();
        System.out.println("Finished all threads!");
    }
}
