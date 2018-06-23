package Lesson08_Threads;

public class AnonimThread {// implements Cloneable{

    
    public static void threadAnonim() {
        new Thread(new Runnable() {
            int i = 0;

            public void run() {
                try {
                    while (i++ < 100) {
                        Thread.sleep(1000);
                        System.out.print((i) + " ");
                    }
                } catch (InterruptedException ex) {
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        threadAnonim();
    }
}
