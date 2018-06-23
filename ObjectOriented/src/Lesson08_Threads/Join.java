package Lesson08_Threads;

public class Join {

    public static void main(String[] args) {
        //wait 10msc*5
        MyThread10 t1 = new MyThread10("T1");
        //wait 100msc*5
        MyThread2 t2 = new MyThread2("T2");
        t1.start();
        t2.start();

        //If I was not writing anything then main wait until both of them finish
        try {
            t2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main exit");
    }
}

class MyThread10 extends Thread {

    MyThread10(String name) {
        super(name);
    }

    public void run() {
        int r = 10;
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " " + Thread.currentThread().getName() + ", r = " + r);
            try {
                sleep(r);
            } catch (InterruptedException ex) {
            }
        }
        System.out.println(this.getName() + "  Done");
    }
}

class MyThread2 extends Thread {

    MyThread2(String name) {
        super(name);
    }

    public void run() {
        int r = 100;
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + " " + this.getName() + ", r = " + r);
            try {
                sleep(r);
            } catch (InterruptedException ex) {
            }
        }
        System.out.println(this.getName() + "  Done");
    }
}
