/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson03_Observer_My;

/**
 *
 * @author Oleg
 */
public class Main {
    public static void main(String[] args) {
		// Configure Observer structure
                /**
                 * יש לי מבנה כלשהו שיודע להחזיק גופים מסוימים ברגע שאני מזין בו הודעה חדשה 
                 *  MODIFY
                 *  זה מעדכן את כל האנשים באותה הודעה
                 */
       
		MyObserevable s = new MyObserevable();
                
                //כל משתנה כזה יודע להחזיר פונקציית רענון כי הוא ממש את הממשק
                // כל אחד יודע להחזיק בעצם את הלוח ואת השם
                
		Observer Tzili = new Tzili("Tzili");
		Observer Gili = new Gili("Gili");
		Observer Nili = new Nili("Nili");
		s.add_Observer(Tzili);
		s.add_Observer(Gili);
		s.add_Observer(Nili);
		// Change subject and notify observers
		s.setBoard("Homework 1 is ready!");
		s.notifyObservers();
		System.out.println();
		s.setBoard("Homework 2 is ready!");
		s.notifyObservers();
		////
		s.remove_Observer(Gili);
		System.out.println();
		s.setBoard("Homework 3 is ready!");
		s.notifyObservers();
	}
}
