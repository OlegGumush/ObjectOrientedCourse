package Lesson09_Threads;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//import java.util.concurrent.*;

/**
 * The Callable interface is similar to Runnable, in that both are designed for
 * classes whose instances are potentially executed by another thread. A
 * Runnable, however, does not return a result and cannot throw a checked
 * exception.
 */
class MyThread implements Callable<String> {
    int id;
    MyThread(int i) {
        id = i;
    }
    @Override
    public String call(){// throws Exception {
        long t1 = new Date().getTime();// get current UTC time in milliseconds
        System.out.println("Thread id = " + id + " started!");
        try {
            Thread.sleep(new Random().nextInt(300));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread id = " + id + " finished!");
        long t2 = new Date().getTime();// get current UTC time in milliseconds
        return "Thread id = " + id + ",  running time was " + (t2 - t1);
    }
}

public class Pool {

    public static void main(String[] args) {
        //MyThread t = new MyThread(999);    
        //String s = t.call();
        //System.out.println("s = "+s);
        //
        int num = 3;
        
        //אם רוצים להרית טרייד שהוא לא ראנאייבל אפשר רק דרך אקסקיוטור והתשובה תחזור למשתנה או מערך מסוג עתידי
        ExecutorService pool = Executors.newFixedThreadPool(num);
        Future<String> results[] = new Future[num];
        for (int i = 1; i <= num; i++) {
            results[i - 1] = pool.submit(new MyThread(i));
        }
        for (int i = 1; i <= num; i++) {
            try {
                String ans = results[i - 1].get();
                System.out.println("Thread " + i + " returned value: " + ans);
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
        System.out.println("main stopped");
    }
}
