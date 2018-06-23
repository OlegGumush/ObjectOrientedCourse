package Lesson11_Singelton;

//שיטה א לבנות מחלקה שתחזיר לנו רק אובייקט אחד לא ניתן לבנות שתי אובייקטים 
//ממחלקה זו כל ניסיון נוסף נקבל את אותו אחד שכבר בנינו בפעם הראשונה
// אומנם יש כאן בעיה שהמחלקה לא מסונכרנת ושתי טרידים יכולים לכנס ולבנות שתי אובייקטים9
// נפתור בעיה זו ב
// Singelton_Sync

public class Singleton_A {

    private static Singleton_A instance = null;
    private static int i = 0;

    public String toString() {
        return "i = " + i;
    }

    // private constructor
    private Singleton_A() {
        i++;
    }

    public static Singleton_A getInstance() {//static access method
        if (instance == null) {
            instance = new Singleton_A();
        }
        return instance;
    }
}
