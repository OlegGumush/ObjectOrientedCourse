package Lesson09_Threads;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class Job1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Job 1");
    }
    @Override
    public String toString(){
        return "job1";
    }
}

class Job2 implements Runnable {

    public void run() {
        System.out.print("job 2:  ");
        for (int i = 0; i < 4; i++) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
    @Override
    public String toString(){
        return "job2";
    }
}

/**
 * scheduleAtFixedRate method: Creates and executes a periodic action that
 * becomes enabled first after the given initial delay, and subsequently with
 * the given period; that is executions will commence after initialDelay then
 * initialDelay+period, then initialDelay + 2 * period, and so on. If any
 * execution of the task encounters an exception, subsequent executions are
 * suppressed. Otherwise, the task will only terminate via cancellation or
 * termination of the executor. If any execution of this task takes longer than
 * its period, then subsequent executions may start late, but will not
 * concurrently execute.
 *
 * Parameters: command - the task to execute initialDelay - the time to delay
 * first execution period - the period between successive executions unit - the
 * time unit of the initialDelay and period parameters  *
 * ScheduledThreadPoolExecutor constructor Parameters: corePoolSize - the number
 * of threads to keep in the pool, even if they are idle, unless
 * allowCoreThreadTimeOut is set  *
 */
public class ScheduledThreads {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor stpe = new ScheduledThreadPoolExecutor(5);
        System.out.println(""+stpe.toString());
        stpe.scheduleAtFixedRate(new Job1(), 1,2, TimeUnit.SECONDS);
        stpe.scheduleAtFixedRate(new Job2(), 1,2, TimeUnit.SECONDS);
        
        //System.out.println(""+stpe.toString());
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(""+stpe.toString());
        stpe.shutdownNow();
        System.out.println(""+stpe.toString());
    }  
}
