package Lesson08_Threads;
//If I want to stop thread  betest use boolean variable

class FirstThread extends Thread {

    private boolean keepGoing = true;

    public FirstThread(String name) {
        super(name);
    }

    public void setKeepGoing(boolean keepGoing) {
        this.keepGoing = keepGoing;
    }

    // The function will run indefinitely or until we stop it .
    //That means we replace the variable keepGoing to false.
    @Override

    public void run() {
        int i = 1;
        while (keepGoing) {
            try {
                System.out.println(Thread.currentThread().getName() + " i = " + i++);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }
}
//Second thred gets first tread ans name

class SecondThread extends Thread {

    FirstThread t;
    int i = 1;

    //constractor
    public SecondThread(String name, FirstThread t) {
        super(name);
        this.t = t;
    }

    public void run() {
        //Wait a second, given to the first run
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
        }
        //We test if the first still alive
        //The answer will always be yes!! that we still do not close him
        System.out.println("SecondThread:  t.isAlive()? " + t.isAlive());
        //Now secoond  turn off the first thread
        System.out.println(Thread.currentThread().getName() + " stops t1");
        //check if alive always true
        if (t.isAlive()) {
            //t - stop
            t.setKeepGoing(false);

            //Checking how long it takes until it stops working
            long start = System.currentTimeMillis();
            while (t.isAlive());
            long end = System.currentTimeMillis();
            System.out.println("time: " + (end - start) + " ms");
        }
        System.out.println("First Thread is Alive? " + t.isAlive());
    }
}

public class Stop_With_Bollean {

    public static void main(String[] args) {
        FirstThread ft = new FirstThread("FirstThread");
        SecondThread st = new SecondThread("SecondThread", ft);
        ft.start();
        st.start();
        System.out.println("st is Alive? " + st.isAlive());
        try {
            Thread.sleep(1000);
        } catch (Throwable ex) {
        }
        System.out.println("st is Alive? " + st.isAlive());
        System.out.println("in main " + Thread.currentThread().getName());
    }
}
