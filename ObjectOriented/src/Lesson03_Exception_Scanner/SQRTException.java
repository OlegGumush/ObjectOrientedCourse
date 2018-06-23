package Lesson03_Exception_Scanner;
import java.util.Locale;
import java.util.Scanner;

public class SQRTException {
    
	static Scanner sc;
        
	public static void openScanner(){
		Locale.setDefault(Locale.US);
		sc = new Scanner(System.in);
		sc.useLocale(Locale.US);
	}
        
	public static void closeScanner(){
		sc.close();
	}
	
	public static double mySqrt(double x) throws MySqrtException{
		if (x >= 0){
			return Math.sqrt(x);
		}
		else{
			throw new MySqrtException("MySqrtException: negative number!!!");
		}
	}
	/* A Locale object represents a specific geographical, political, or cultural region. 
	An operation that requires a Locale to perform its task is called locale-sensitive 
	and uses the Locale to tailor information for the user. For example, displaying a 
	number is a locale-sensitive operation� the number should be formatted according to the 
	customs and conventions of the user's native country, region, or culture.	 
*/
	public static double negativeSqrtExample1(){
		double x=-5.0, y=0;
		while (x < 0){
			x = sc.nextDouble();//MyConsole.readDouble("get number: ");
			try{
				y = mySqrt(x);
				System.out.println("y = "+y);
			}
			catch(ArithmeticException e){
				System.out.println("\nsqrt from negative number");
				e.printStackTrace();
			}
			catch(Exception e){
				System.err.println(e);				
			}
			finally{
				System.out.println("finally it works!");	
			}
			System.out.println("continue");
		}
		return y;
	}
	public static double negativeSqrtExample2() throws MySqrtException{
		double x=-5.0, y=0;
		while (x < 0){
			x = sc.nextDouble();//MyConsole.readDouble("get number: ");
			y = mySqrt(x);
			System.out.println("y = "+y);
		}
		return y;
	}
	public static void main(String[] args) {
		System.out.println("Math.sqrt(-1) = " + Math.sqrt(-1));
		//System.out.println("\nnegativeSqrtExample1:");
		///
		openScanner();
		//negativeSqrtExample1();
		System.out.println("\nnegativeSqrtExample2:");
		try {
			negativeSqrtExample2();
		} catch (MySqrtException e) {
			e.printStackTrace();
		}
		closeScanner();
	}
}
