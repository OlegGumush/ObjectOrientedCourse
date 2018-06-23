package Lesson09_Threads_MassageBox;

public class Massage_Box_Senfer_Receiver {

    public static void main(String[] args) {
        MessageBox mb = new MessageBox();
        Sender sender = new Sender(mb, "Sender");
        Receiver receiver = new Receiver(mb, "Receiver");
        sender.start();
        receiver.start();
    }
}
class MessageBox {

    int contents;
    boolean avialable = false;

    public int get() {
        //wait until the sender puts some messages
        while (avialable == false) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        avialable = false;// before return message, rest the flag
        return contents;
    }

    public void put(int val) {
        contents = val;
        avialable = true;
    }
}
//מחלקה שתשלח הודעה ותחזיק בתוכנה את תייבת ההודעות
class Sender extends Thread {

    private MessageBox messBox;
    private String name;

    public Sender(MessageBox messBox, String name) {
        this.messBox = messBox;
        this.name = name;
    }
    //שם בתייבת הודעות כל פעם מספר בין אחד לחמש שמי שמקבל ידפיס
    public void run() {
        for (int i = 1; i <= 5; i++) {
            messBox.put(i);
            System.out.println("#" + name + "  put: " + i);
            try {
                sleep((int) (10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//מחלקה שתקבל הודעה ותחזיק בתוכנה את תייבת ההודעות
class Receiver extends Thread {

    private MessageBox messBox;
    private String name;

    public Receiver(MessageBox messBox, String name) {
        this.messBox = messBox;
        this.name = name;
    }
    //מדפיס את מה שיש בלוח מודעות 
    public void run() {
        int val = 0;
        do {
            val = messBox.get();
            System.out.println("#" + name + "  got: " + val);
        } while (val < 5);
    }
}