package Lesson11_Singelton;

public class Singleton_Sync {

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
