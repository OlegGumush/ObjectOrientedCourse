package Lesson11_Singelton;
//שיטה ב לבנות מחלקה שתחזיר לנו רק אובייקט אחד לא ניתן לבנות שתי אובייקטים 
//ממחלקה זו כל ניסיון נוסף נקבל את אותו אחד שכבר בנינו בפעם הראשונה
// אומנם יש כאן בעיה שהמחלקה לא מסונכרנת ושתי טרידים יכולים לכנס ולבנות שתי אובייקטים9
// נפתור בעיה זו ב
// Singelton_Sync
public class Singleton_B {
	private static final Singleton_B instance = new Singleton_B();
	private Singleton_B() {
		j++;
	}
	static int j=0;
	public String toString(){
		return "j = " + j;
	}
	public static Singleton_B getInstance() {
		return instance;
	}
}
