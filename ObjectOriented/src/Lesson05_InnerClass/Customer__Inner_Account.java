package Lesson05_InnerClass;


public class Customer__Inner_Account{
	private String name;
	private long id;
        private static int ok = 0;
	public Customer__Inner_Account(String name, long id){
		this.name = name;
		this.id = id;
	}
	public String toString(){
		return "name : " + name + "  id : " + id;
	}
	public class Account{
		double balance;
		long num;
                
		public Account(double sum, long num){
			this.num = num;
			balance = sum;
		}

		public String toString(){
                    //בדרך כלל נקרא עם שם הפונקציה למשתנה או פונקציה סטטית 
                    // בגלל שכאן אני רוצה לגשת לשם ונגיד ולי גם היה משתנה בשם
                    // name
                    //היתי צריך לגשת ככה
                    // Customer__Inner_Account.this.name
                    //כדי שידע להבדיל בין שלי לשלו 
                    // Customer__Inner_Account.name //not good not static
                        String s = Customer__Inner_Account.this.name;
                        System.out.println("if id changed"+ok);
			return "The Account number " + num + " belongs to " + name//Customer__Inner_Account.this.name
					+ " and its balance is " + balance;
		}
	}
	public static void main(String[] args) {
                // error because inner class
                //Account a = new Account(2000,10);
                //אם אני רוצה לפתוח קלאס פנימי אני יעשה את זה בעזת אובייקט ממחלקת האב של המחלקות
            
                //בונה רגיל כי הוא הכי חיצוני
		Customer__Inner_Account customer = new Customer__Inner_Account("Dany",2929292327L);
                //דרך אובייקט נבנה מחלקה פנימית
		Customer__Inner_Account.Account account1 = customer.new Account(2000, 1);
		Customer__Inner_Account.Account account2 = customer.new Account(4000, 2);
		Customer__Inner_Account.Account account3 = customer.new Account(3000, 3);
		System.out.println(account1);
		System.out.println(account2);
		System.out.println(account3);
               
                //ככה באופן מקוצר 
		Customer__Inner_Account.Account acc2 = new Customer__Inner_Account("Yael",123456789L).new Account(10000, 1);
		Customer__Inner_Account.Account acc3 = new Customer__Inner_Account("Yael",123456789L).new Account(25000, 2);
		System.out.println(acc2);
		System.out.println(acc3);
                //Account ac = new Account(2000, 1);//error
	}
}
/**
 *  OUTPUT
	The Account belongs to Dany and its balance is 2000.0
	The Account belongs to Dany and its balance is 4000.0
	The Account belongs to Dany and its balance is 3000.0
 */
