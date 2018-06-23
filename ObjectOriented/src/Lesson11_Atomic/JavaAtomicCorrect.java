package Lesson11_Atomic;
//כאן שתי טרידים צריכים להגדיל משתנה אחד לכן אני אגדיר אותו כמשתנה אטומי
import java.util.concurrent.atomic.AtomicInteger;
public class JavaAtomicCorrect {
	 
    public static void main(String[] args) throws InterruptedException {
 
    	ProcessingThreadCorrect pt = new ProcessingThreadCorrect();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Processing count=" + pt.getCount());
        System.out.println("Procceng "+pt.counter);
    }
 
}
 
 
class ProcessingThreadCorrect implements Runnable {
    private AtomicInteger count = new AtomicInteger(0);
    public int counter=0;
 
    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            processSomething(i);
            System.out.println("atomic "+count.incrementAndGet());
            System.out.println(counter++);
        }
    }
 
 
    public int getCount() {
        return this.count.get();
    }
 
 
    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
}
