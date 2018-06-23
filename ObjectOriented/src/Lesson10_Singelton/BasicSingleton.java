package Lesson10_Singelton;

import javax.swing.SpringLayout;

public class BasicSingleton {

    public static void main(String[] args) {
        //בפנים יכנס לבנאי ויגדיל את המשתנה
        Singleton_1 g = Singleton_1.getInstance();
        Singleton_1 h = Singleton_1.getInstance();
        Singleton_1 j = Singleton_1.getInstance();
        System.out.println(g.toString());
        System.out.println(h.toString());
        System.out.println(j.toString());
        //לא יכנס לבנאי כי בניתי משנה סטטי לפני הוא רק יחזיר אותו 
        Singleton_2 a = Singleton_2.getInstance();
        Singleton_2 b = Singleton_2.getInstance();
        Singleton_2 c = Singleton_2.getInstance();
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        //מסונכרן יש את מילת המפתח 
        //syncronized
        //לכן שתי טרידים לא יכולים להכנס בו זמנית ולהחזיר לי שתי אובייקטים
        Singleton_Sync s = Singleton_Sync.getInstance();
        Singleton_Sync r = Singleton_Sync.getInstance();
        Singleton_Sync t = Singleton_Sync.getInstance();
        System.out.println(s.toString());
        System.out.println(r.toString());
        System.out.println(t.toString());
    }
}

class Singleton_1 {

    private static Singleton_1 instance = null;
    static int i = 0;

    public String toString() {
        return "i = " + i;
    }
    // private constructor

    //בנאי פרטי אפשר לגשת רק בתוך המחלקה
    private  Singleton_1() {
        i++;
    }

    public static Singleton_1 getInstance() {//static access method
        if (instance == null) {
            instance = new Singleton_1();
        }
        return instance;
    }
    
}

class Singleton_2 {

    private static final Singleton_2 instance = new Singleton_2();
    static int j = 0;

    private Singleton_2() {
        j++;
    }

    public String toString() {
        return "j = " + j;
    }

    public static Singleton_2 getInstance() {
        return instance;
    }
}

class Singleton_Sync {

    private static Singleton_Sync instance = null;

    private Singleton_Sync() {
    }

    public static synchronized Singleton_Sync getInstance() {
        if (instance == null) {
            instance = new Singleton_Sync();
        }
        return instance;
    }
}
