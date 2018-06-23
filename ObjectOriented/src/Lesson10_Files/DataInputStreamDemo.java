package Lesson10_Files;
/**
 * בקובץ זה רוב העבודה היא עם קריאה וכתיבה של אובייקטים פרימיטיביים
 * 
 * FileOutputStream fos = new FileOutputStream(fileName);
 * DataOutputStream output = new DataOutputStream(fos);
 * מיועד לכתיבה קובץ  לאובייקטים פרימיטיביים
 * כלומר לא נוכל להדפיס נקודה או סטודנט
 * 
 * FileInputStream fis = new FileInputStream(fileName);
 *   DataInputStream input = new DataInputStream(fis);
 *  
 *  מיועד לקריאה מקובץ אבל קריאה רק של משתנים פרימיטיביים
 * 
 *  לקיראה וכתיבה של אובייקטים נשתמש ב 
 * ObjectOutputStream
 * ObjectInputStream
 */



//UTF - Unicode Transformation Format, 8-bit 
// 1.One-byte codes are used only for the ASCII values 0 through 127. 
//In this case the UTF-8 code has the same value as the ASCII code. 
import Lesson10_FileObjectStream.Point;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataInputStreamDemo {

    public static void dataWrite(String fileName) {
        String[] names_arr = {"Abraham", "Izhak", "Yaakov"};
        int[] ages = {34, 23, 47};
        double[] weights = {65.7, 78.3, 53.9};
        try {
            //two kinds DataOutputStream , ObjectOutputStream
            FileOutputStream fos = new FileOutputStream(fileName);
            DataOutputStream output = new DataOutputStream(fos);
            output.writeInt(names_arr.length);
            for (int i = 0; i < names_arr.length; i++) {
                //Strings
                output.writeUTF(names_arr[i]);
                //Ints
                output.writeInt(ages[i]);
                //Doubles
                output.writeDouble(weights[i]);
            }//for
            Point p = new Point(3, 4);
            output.writeUTF(p.toString());
            output.close();
            fos.close();
        } catch (IOException e) {
            System.err.println("I/O error \n" + e.toString());
            System.exit(1);
        }
    }

    public static void dataRead(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            DataInputStream input = new DataInputStream(fis);

            int count = input.available();
            System.out.println("count = " + count);
            int num = input.readInt();
            System.out.println("number of strings = " + num);
            for (int i = 0; i < num; i++) {
                String name = input.readUTF();
                int age = input.readInt();
                double weight = input.readDouble();
                System.out.println("Name: " + name + " age: " + age + " weight: " + weight);
            }
            String s = input.readUTF();
            System.out.println(s);
            input.close();
        } catch (IOException e) {
            System.err.println("I/O problem with the file\n" + e.toString());
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        String fileName = "C:\\temp\\info.txt";
        dataWrite(fileName);
        dataRead(fileName);
    }
}
