package Lesson08_Threads;

import java.util.logging.Level;
import java.util.logging.Logger;

class Pie extends Thread {

    boolean negative = true;
    double pi = 0.0; // Initializes to 0.0, by default

    public void run() {
        for (long i = 3; i < 1000000000; i = i + 2) {
            if (negative) {
                pi = pi - (1.0 / i);
            } else {
                pi = pi + (1.0 / i);
            }
            negative = !negative;
        }
        pi = pi + 1.0;
        pi = pi * 4.0;
        System.out.println("Finished calculating PI");
    }
}

public class Thread_Calc_PI {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " is daemon? " + Thread.currentThread().isDaemon());
        //new thread
        Pie mt = new Pie();
        mt.start();
        int i = 0;
        try {
            //I wait as long as he live
//        while (mt.isAlive()) {
//            try {
//                Thread.sleep(1000);
//                System.out.println("Thread is alive " + (i++));
//                //mt.interrupt();//does'n work
//            } catch (InterruptedException e) {
//            }
//        }
            mt.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Thread_Calc_PI.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("pi = " + mt.pi);
    }
}
