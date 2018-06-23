package Lesson11_Atomic;
//הפונקציה כן טובה כי את הגדלת הקאונטר אני שולח לפונקציה שהיא סינכרוניזד
public class JavaAtomicSynch {

    public static void main(String[] args) throws InterruptedException {

        ProcessingThreadSynch pt = new ProcessingThreadSynch();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Processing count=" + pt.getCount());
    }
}

class ProcessingThreadSynch implements Runnable {

    private int count;

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            processSomething(i);
            incrementCount();
        }
    }

    public int getCount() {
        return this.count;
    }

    public synchronized void incrementCount() {
        count++;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
