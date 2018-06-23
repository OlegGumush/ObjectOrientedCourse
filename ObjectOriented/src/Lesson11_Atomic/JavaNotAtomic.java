package Lesson11_Atomic;

//http://www.journaldev.com/1095/java-atomic-operations-atomicinteger-example
public class JavaNotAtomic {

    public static void main(String[] args) throws InterruptedException {
        //אני רוצה את הקאונטר משותף לשתי טריידים 
        //לכן אני אבנה ראנייבל אחד ואשלח אותו לבנאי של שתי טריידים
        //התוכנית לא טובה כי הטרידים יכולים לגשת לאותו משתנה בלי סנכרון
        ProcessingThread pt = new ProcessingThread();

        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Processing count=" + pt.getCount());
    }
}

class ProcessingThread implements Runnable {

    private Integer count = 0;

    @Override
    public void run() {
        for (int i = 1; i < 11; i++) {
            processSomething(i);
            count++;
        }

    }

    public int getCount() {
        return this.count;
    }

    private void processSomething(int i) {
        // processing some job
        try {
            Thread.sleep(i * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/**
 * If you will run above program, you will notice that count value varies
 * between 5,6,7,8. The reason is because count++ is not an atomic operation. So
 * by the time one threads read it�s value and increment it by one, other thread
 * has read the older value leading to wrong result.
 */
