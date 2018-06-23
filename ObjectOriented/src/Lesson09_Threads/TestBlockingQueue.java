package Lesson09_Threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

//Blocking Queue if we puts a object the queue wait until another thread do take
class Producer implements Runnable {


    private int i = 0;
    private final BlockingQueue<Integer> queue;

    Producer(BlockingQueue<Integer> q) {
        queue = q;
        i = 0;
    }

    public void run() {
        try {
            while (i <= 5) {
                queue.put(produce());
                
            }
        } catch (InterruptedException ex) {
        }
    }

    public int produce() {
        i++;
        System.out.println("produce i=" + i);
        return i;
    }
}
//
class Consumer implements Runnable {

    private final BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> q) {
        queue = q;
    }
    int j = 0;

    public void run() {
        try {
            while (j <= 5) 
            {
                j++;
                int i = queue.take();
                consume(i);
            }
        } catch (InterruptedException ex) {
        }
    }

    void consume(int x) {
        System.out.println("consume x=" + x);
    }
}

public class TestBlockingQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> q = new SynchronousQueue<Integer>(true);
        Producer p = new Producer(q);
        Consumer c = new Consumer(q);

        new Thread(p).start();
        //Thread t = new Thread(p) , p.start();
        new Thread(c).start();
    }
}
