package core.multithreading.udemy._5_threadPools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Thread pools
 * <p/>
 * allows to recycle threads - instead of creating a new one each time for the job, allows to start a new task as soon as finished with current one
 */
public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 5; i++) {
            executor.submit(new Processor(i));
        }

        executor.shutdown();

        System.out.println("All tasks submitted");

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed");
    }
}

class Processor implements Runnable {
    private int id;

    public Processor(int id) {
        this.id = id;
    }


    @Override
    public void run() {
        System.out.println("Starting " + id);

        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finishing " + id);
    }
}
