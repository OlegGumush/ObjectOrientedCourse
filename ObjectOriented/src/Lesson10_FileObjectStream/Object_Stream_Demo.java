package Lesson10_FileObjectStream;

import java.io.*;
import java.util.*;

public class Object_Stream_Demo {

    public static void writeObject() {
        Date toDay = new Date();
        Point p1 = new Point(3, 4);
        Point p2 = new Point(5, 6);
        Rectangle r = new Rectangle(p1, p2);
        try {
            FileOutputStream myFile = new FileOutputStream("C:\\info.txt");
            ObjectOutputStream oos = new ObjectOutputStream(myFile);
            oos.writeObject(toDay);
            oos.writeObject(r);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readObject() {
        Date toDate = null;
        Rectangle r = null;
        try {
            FileInputStream myFile = new FileInputStream("C:\\info.txt");
            ObjectInputStream ois = new ObjectInputStream(myFile);
            toDate = (Date) ois.readObject();
            r = (Rectangle) ois.readObject();
            ois.close();
        } catch (Exception error) {
            error.printStackTrace();
        }
        System.out.println(toDate);
        System.out.println(r);
        Rectangle.printStaticFunction();
        r.printStaticVariable();
    }

    public static void main(String[] args) {
        writeObject();
        readObject();
    }
}
