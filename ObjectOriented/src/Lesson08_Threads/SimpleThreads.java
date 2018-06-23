package Lesson08_Threads;

import java.util.logging.Level;
import java.util.logging.Logger;

class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (long i = 1; i <= 5; i++) {
            System.out.println("i = " + i + "  " + this.getName() + " Priority: " + this.getPriority());
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName() + "  DONE!");
    }
}

class MyThread1 implements Runnable  {

    
    String name;

    public MyThread1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            
            int r = 100;//(int) (Math.random() * 1000);
            System.out.println("i = " + i + ",  name = " + name + ", r = " + r + " ms");
            try {
                Thread.sleep(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("into run of MyThread1 currentThread" + Thread.currentThread());
        System.out.println(this.name + "  DONE!");
    }
}

public class SimpleThreads {
    ///////

    public static void MyThread_Demo() {
        
        //MyThread extends Thread
        MyThread t1 = new MyThread("T1");
        MyThread t2 = new MyThread("T2");
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        //new MyThread("T3").start();
    }
    //////

    public static void MyThread1_Demo() {
        //MyThread1 mth = new MyThread1("T1");
        Thread t1 = new Thread(new MyThread1("T1"));
        Thread t2 = new Thread(new MyThread1("T2"), "Oren");
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.start();//500 msc
        t1.start();//500 msc
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        //Thread.currentThread לא מתייחס ל  
        //t1 , t2
        System.out.println("into MyThread1_Demo currentThread" + Thread.currentThread());
        System.out.println("t1.isAlive()? " + t1.isAlive());
        System.out.println("t2.isAlive()? " + t2.isAlive());
    }

    public static void main(String[] args) {
        //MyThread_Demo();
        
        MyThread1_Demo();
        System.out.println("into MyThread1_Demo currentThread" + Thread.currentThread());
        System.out.println("current thread is alive? " + Thread.currentThread().isAlive());

       // System.out.println("current thread name: " + Thread.currentThread());
        //System.out.println("current thread is alive? " + Thread.currentThread().isAlive());
        //System.out.println("main done");
    }
}
