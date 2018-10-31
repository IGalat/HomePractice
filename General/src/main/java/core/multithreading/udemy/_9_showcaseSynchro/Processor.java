package core.multithreading.udemy._9_showcaseSynchro;

import java.util.LinkedList;
import java.util.Random;

/**
 * just low-level synchronization, a working and good example
 */
public class Processor {
    private LinkedList<Integer> list = new LinkedList<Integer>();
    private static final int LIMIT = 10;
    private Object lock = new Object();

    public void produce() throws InterruptedException {
        int value = 0;

        while(true) {
            synchronized(lock) {
                while(list.size() == LIMIT)
                    lock.wait();   //IMPORTANT: need to call wait and notify on the object that lock is on
                list.add(value++);

                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        Random random = new Random();

        while(true) {
            synchronized(lock) {
                while(list.size() == 0)
                    lock.wait();

                System.out.printf("List size is " + list.size());
                int value = list.removeFirst();
                System.out.println("; value = " + value);

                lock.notify();
            }

            Thread.sleep(random.nextInt(1000));

        }
    }
}
