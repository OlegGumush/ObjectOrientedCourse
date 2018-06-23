package Lesson10_FileObjectStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
////////////////////////////////////////////////////////////////////////////////////////////
//Object Stream 
//מיועד לשמירת אובייקטים בתוך קובץ כשאנחנו כותבים הוא מקודד את זה בתוך הקובץ
//מבחוץ קשה להבין מה יש שם אבל כשאנחנו קוראים מהקובץ בעזרת פונקציות של גואה הכל נראה תקין
/////////////////////////////////////////////////////////////////////////////////////////////


public class ObjectStreamDemo2 {

	public static int writeObject() throws IOException{
		Date toDay = new Date();
                Point p[]=new Point[10];
		for (int i = 0; i < p.length; i++) {
			p[i] = new Point(3+i, 4+i);
		}
		try{
                    //פותח קודם כל קובץ
                    //שם אותו באובייקט אאוטפוט ואיתו אני עובד
			FileOutputStream myFile = new FileOutputStream("C:\\info.txt");
			ObjectOutputStream oos = new ObjectOutputStream(myFile);
			oos.writeObject(toDay);
			oos.writeObject(p);
			oos.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return p.length;
	}
	public static void readObject(int np) throws IOException{
		Date toDate = null;
		try{
                    //פותחים קובץ לקריאה
			FileInputStream myFile = new FileInputStream("C:\\info.txt");
			ObjectInputStream ois = new ObjectInputStream(myFile);
                        //בקובץ יש לנו דאטא אחת הוא ימצא אותה וישים
			toDate = (Date)ois.readObject();
			Point [] points = new Point[np];
			points = (Point[])ois.readObject();
			for (int i=0; i<np; i++){
				System.out.println(points[i]);
			}
                        System.out.println(toDate);

			ois.close();
		}
		catch (Exception error){
			error.printStackTrace();
		}
	}
	public static void main(String[] args) {
		try{
			int np = writeObject();
			readObject(np);
		}
		catch (Exception error){
			error.printStackTrace();
		}
	}
}
