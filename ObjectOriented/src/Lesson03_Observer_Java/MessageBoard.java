/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson03_Observer_Java;

import java.util.Observable;

//בדוגמא למטה אני בונה בעצמי את הלוח מודעות כאן אנחנו לוקחים הכל בירושה
//הלוח שלי בעצם מחזיק בפנים וקטור
public class MessageBoard extends Observable {
    
   //אם ירשנו מאובסרוראיבל יש לי בפנים כבר אוסף רק צריך להכניס לתוכו וכל הפונקציות עברו בירושה
    private String message;

    public String getMessage() {
        return message;
    }
    //הוא ידע להוסיף לאוסף שלו אין צורך לפתוח אחד משלי
    public void add(Student o){
        this.addObserver(o);
    }
    public void changeMessage(String message) {
        //מעדכן הודעה
        this.message = message;
        //חייב לשים אישור על זה ששיניתי את הנתונים
        setChanged();      
        //כשאני קורא לפונקציה הזאת בפנים בתוכה היא מפעילה 
        //update
        //על כל האוביקטים באוסף
        notifyObservers(message);
    }
}
