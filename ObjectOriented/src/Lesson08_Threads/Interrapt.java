package Lesson08_Threads;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

class TryInterrupt extends Thread {

    private int i = 0;
    private String name;
    private int aWhile;

    public TryInterrupt(String name, int delay) {
        this.name = name;
        aWhile = delay;
    }

    public void run() {
        try {
            while (true) {
                System.out.println(name + ",  i = " + i++);
                sleep(aWhile);
            }
        } catch (InterruptedException e) {
            System.out.println(name + e);
        }
    }
}

class TryInterrupt2 extends Thread {

    private String name;

    public TryInterrupt2(String name) {
        this.name = name;
    }

    public void run() {
        while (true);
    }
}

public class Interrapt {

    public static void main(String[] args) {
        Thread t = new TryInterrupt("A ", 1000);
        t.start();
        if (t.isAlive()) {
            System.out.println("t before interrupt t.isAlive()? " + t.isAlive());
            t.stop();
            try {
                sleep(20);
            } catch (InterruptedException ex) {
                Logger.getLogger(Interrapt.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("t after interrupt t.isAlive()? " + t.isAlive());
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().toString() + e);
        }
        System.out.println("t after sleep and interrupt t.isAlive()? " + t.isAlive());
        ///////////////
        Thread t2 = new TryInterrupt2("B");
        t2.start();
        t2.interrupt();
        System.out.println("t2 after interrupt t.isAlive()? " + t2.isAlive());
        long start = System.currentTimeMillis();
        //infinity loop 
        while (t2.isAlive());
        long end = System.currentTimeMillis();
        System.out.println("time of t2: " + (end-start) + " ms");

        System.out.println("t2 after sleep and interrupt t.isAlive()? " + t2.isAlive());
    }
}
