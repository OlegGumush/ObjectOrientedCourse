package Lesson09_Threads;

public class DaemonThread2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main starts");

        Thread t = new Thread() {
            @Override
            public void run() {
                System.out.println("run starts");
                int i = 0;
                try {
                    while (i < 10) {
                        try {
                            i++;
                            Thread.sleep(1000);
                        } catch (InterruptedException x) {
                        }
                        System.out.println("t runs: " + Thread.currentThread().isDaemon());
                    }
                } finally {
                    System.out.println("Filnally: run stops");
                }
            }
        };
        //יפסיק לעבוד עם המיין
        t.setDaemon(true);
        t.start();
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }

        System.out.println("End of the main method execution");
    }
}
