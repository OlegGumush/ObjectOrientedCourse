//עוד שיטה לבנות מחלקה של סינגלטון מסונכרנת לא ברור איך המשתנה המיוחד עוזר לנו
// volatile
package Lesson11_Singelton;

public class Singleton_V {

    private static volatile Singleton_V instance = null;

    private Singleton_V(){}
    
    public static Singleton_V getInstance() {
        if (instance == null) {
            synchronized(Singleton_V.class){
                 if (instance == null) {
                     instance = new Singleton_V();
                 }
            }
        }
        return instance;
    }
}
