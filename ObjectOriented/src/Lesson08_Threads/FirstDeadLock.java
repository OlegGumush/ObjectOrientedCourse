package Lesson08_Threads;

public class FirstDeadLock {

    public static Thread t1, t2;

    public static void main(String[] args) {
        final Point resource1 = new Point(1, 1);
        final Point resource2 = new Point(2, 3);

        // t1 tries to lock resource1 then resource2
        t1 = new Thread() {
            public void run() {
                // t1 Lock resource 1
                synchronized (resource1) {
                    System.out.println("Thread 1: locked resource 1");

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                    }
                    //Wait until t2 ends with resourse 2 -- NEVER -- t2 waits till t1 will release resourse1
                    synchronized (resource2) {
                        System.out.println("Thread 1: locked resource 2");
                    }
                }
                System.out.println("t1 DONE!");
            }
        };

        // t2 tries to lock resource2 then resource1
        t2 = new Thread() {
            public void run() {
                //A good solution is ask if t1 still alive Only then enter
                //while (t1.isAlive());
                synchronized (resource2) {
                    System.out.println("Thread 2: locked resource 2");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                    }

                    resource1.setX(22);

                    synchronized (resource1) {
                        System.out.println("Thread 2: locked resource 1");
                    }
                }
                System.out.println("t2 DONE!");
            }
        };

        // If all goes as planned, deadlock will occur,
        // and the program will never exit.
        t1.start();
        t2.start();
    }
}
/**
 * Thread 1: locked resource 1 Thread 2: locked resource 2
 */
