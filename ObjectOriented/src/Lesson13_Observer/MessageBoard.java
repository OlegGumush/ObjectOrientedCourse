package Lesson13_Observer;

import java.util.Observable;
import java.util.Observer;
//כאן אני עובד עם המחלקה והממשק של גואה
public class MessageBoard extends Observable {

    private String message;

    public String getMessage() {
        return message;
    }

    public void changeMessage(String message) {
        this.message = message;
        //חייב לעדכן ששינינו את ההודעה אחרת לא יקרה כלום
        setChanged();
                //הפקודה הזאת עוברת על כל המאזינים ומפעילה אצליהם את הפונקציה 
        //UPDATE
        notifyObservers(message);
    }
}

class Student implements Observer {

    String name;

    public Student(String name) {
        this.name = name;
    }
    //פונקציה שצריכים לממש מקבלים אובייקט והודעהכל פעם שמעדכנים את כולם
    
    public void update(Observable o, Object arg) {
        System.out.println(name + ": My Message board changed: " + arg);
    }
}

class Main {

    public static void main(String[] args) {
        MessageBoard board = new MessageBoard();
        //פותח שתי מאזינים
        Student ran = new Student("Ran");
        Student dov = new Student("Dov");
        //מוסיף אותם לרשימה 
        board.addObserver(ran);
        board.addObserver(dov);
        //משנה הודעה אחרי ששיניתי את ההודעה כולם יקבלו עידכון על שינוי ההודעה וידפיסו
        board.changeMessage("Workshop is postponed to Wednesday");
        board.changeMessage("The first task is in your personal site");
    }
}
