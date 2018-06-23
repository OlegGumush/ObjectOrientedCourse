/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson03_Observer_Java;

/**
 *
 * @author Oleg
 */
public class Main {
   	public static void main(String[] args) {
                //כשאני בונה משתנה שיורש מ
                //observable
                //המשנה הזה נהיה אוטומטים אוסף
                //אנחנו נוסיף לו אובייקטיס שממשו את הממשק
                //observer
                //וברגע שאני ארצה לעדכן הודעה כל האוסף יתעדכן
		MessageBoard board = new MessageBoard();
                
		Student ran = new Student("Ran");
		Student dov = new Student("Dov");
                Student Oleg = new Student("Oleg");
                //אני יודע להוסיף כי זה וקטור
                board.addObserver(Oleg);
		board.addObserver(ran);
		board.addObserver(dov);
                board.deleteObserver(Oleg);
                //ברגע שאני משנה הודעה בפונקציה הוא שם תהודעה מעדכן שההודעה שונת ומרענן את כל המשתנים בוקטור
		board.changeMessage("Oleg");
		board.changeMessage("The first task is in your personal site");
                
	} 
}
