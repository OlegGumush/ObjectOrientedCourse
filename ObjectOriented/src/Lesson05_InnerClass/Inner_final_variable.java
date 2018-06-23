package Lesson05_InnerClass;

public class Inner_final_variable {

    public static void main(String args[]) {
        //בונים לקוח בבנק
        CustomerBank hanan = new CustomerBank("Hanan", 2929292327L);
        //אחרי שבנינו אותו ניגשים למחלקה הפנימי שלו ובונים אותה
        CustomerBank.Account account1 = hanan.new Account(2000);
        CustomerBank.Account account2 = hanan.new Account(4000);
        System.out.println("account1: " + account1);
        System.out.println("account2: " + account2);
        
        //בהתחלה אני בונה את החיצוני ובעזרתו אני בונה את הפנימי
        CustomerBank a = new CustomerBank("Oleg",10);
        CustomerBank.Account a1 = a.new Account (100);
        
        //כאן נבנה אקואונט אבל מה שיחזור מהפונקציה זה משהו שיורש ממנו באופן מקוצר כי זה בפונקציה
        CustomerBank.Account account1US = account2.getUSADollarAccount(4.0);
        System.out.printf("\naccount1US (account1 in US$) is : %10.3f\n", account1US.balance);
        System.out.println("account1US in NIS is : " + account1US.getNIS());
    
    
    }
}

class CustomerBank {

    private String name;
    private long id;

    public CustomerBank(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return "name : " + name + "  id : " + id;
    }

    public class Account {

        double balance;
        long num;

        public Account() {
        }

        public Account(double sum) {
            balance = sum;
        }

        public double getNIS() {
            return balance;
        }

        //אם קיימת פונקציה שמחזיקה קלאס המשתנים שהיא מקבל חייבים להיות פיינאל
        //כאן אנחנו קצת מרחיווים את הקלאס של החשבון 
        public Account getUSADollarAccount(final double exchangeRate) {
            class USADollarAccount extends Account {

                public USADollarAccount() {
                    balance = Account.this.balance / exchangeRate;
                }

                public double getNIS() {
                    return exchangeRate * balance;
                }
            }
            return new USADollarAccount();
        }

        public String toString() {
            return "The Account belongs to "
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    + CustomerBank.this.name + " and its balance is " + balance;
        }
    }// end class Account
}// end class CustomerBank
/**
 * OUTPUT: account1: The Account belongs to Hanan and its balance is 2000.0
 * account2: The Account belongs to Hanan and its balance is 4000.0
 *
 * account1US (account1 in US$) is : The Account belongs to Hanan and its
 * balance is 480.7692307692308 account1US in NIS is : 2000.0
 */
