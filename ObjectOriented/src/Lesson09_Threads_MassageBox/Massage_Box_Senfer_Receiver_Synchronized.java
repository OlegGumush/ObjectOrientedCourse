package Lesson09_Threads_MassageBox;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Massage_Box_Senfer_Receiver_Synchronized {

    public static void main(String[] args) {
        MessageBoxSync mb = new MessageBoxSync();
        SenderSync sender = new SenderSync(mb, "Sender");
        ReceiverSync receiver = new ReceiverSync(mb, "Receiver");
        sender.start();
        receiver.start();
    }
}

class MessageBoxSync {

    int contents;
    boolean avialable = false;

    //הטרייד שיגיע לפה ראשון יכנס ויחכה עד שישימו הודעה מסויימית ויעשו נוטיפי לשחרר 
    public synchronized int get() {
        //wait until the sender puts some messages
        while (!avialable) {
            try {
                wait(); // wait for sender to write and notify
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        avialable = false;// before return message, rest the flag
        notify();// notify sender
        return contents;
    }

    public synchronized void put(int val) {
        //		synchronized(this){
        while (avialable) {
            try {
                wait(); // wait for sender to write and notify
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        contents = val;
        avialable = true;
        notify();
    }
}

class SenderSync extends Thread {

    private MessageBoxSync messBox;
    private String name;

    public SenderSync(MessageBoxSync messBox, String name) {
        this.messBox = messBox;
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            messBox.put(i);
            System.out.println("#" + name + "  put: " + i);
            try {
                sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(SenderSync.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

//}
class ReceiverSync extends Thread {

    private MessageBoxSync messBox;
    private String name;

    public ReceiverSync(MessageBoxSync messBox, String name) {
        this.messBox = messBox;
        this.name = name;
    }

    public void run() {
        int val = 0;
        do {
            val = messBox.get();
            System.out.println("#" + name + "  got: " + val);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(SenderSync.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (val < 5);
    }
}
