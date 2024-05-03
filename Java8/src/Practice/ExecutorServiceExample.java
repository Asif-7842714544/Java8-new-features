package Practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
//        Single Thread Executor
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 1; i < 5; i++) {
            int taskId = i;
            singleThreadExecutor.execute(() -> {
                System.out.println("Single thread task" + taskId + "executed by Thread " + Thread.currentThread().getName());
            });
        }
        singleThreadExecutor.shutdown();

//        Fixed Thread Pool
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 1; i < 50; i++) {
            int taskId = i;
            fixedThreadPool.execute(() -> {
                System.out.println("Fixed thread task" + taskId + "executed by Thread " + Thread.currentThread().getName());
            });
        }
        fixedThreadPool.shutdown();

//        cached Thread pool
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 50; i++) {
            int taskId = i;
            cachedThreadPool.execute(() -> {
                System.out.println("Cached thread task" + taskId + "executed by Thread " + Thread.currentThread().getName());
            });
        }
    }

}
