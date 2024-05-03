package Practice;

import java.util.concurrent.atomic.AtomicInteger;

class sharedContent {
    private AtomicInteger count = new AtomicInteger(0);
//private volatile int count=0;
    public void incrementCount() {
        count.incrementAndGet();
//        count++;
    }


    public int getCount() {
        return count.get();
//                return count;

    }

}

public class MultiThreading {
    private volatile static int n = 0;

    public static void main(String[] args) throws InterruptedException {
        sharedContent sharedContent = new sharedContent();
        //        Thread 1
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            for (int i = 0; i < 10000; i++) {
                sharedContent.incrementCount();
            }
            System.out.println("Thread 1 finished");
        });
//        Thread 2
        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 started");
            for (int i = 0; i < 10000; i++) {
                sharedContent.incrementCount();
            }
            System.out.println("Thread 2 finished");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(sharedContent.getCount());
    }
}
