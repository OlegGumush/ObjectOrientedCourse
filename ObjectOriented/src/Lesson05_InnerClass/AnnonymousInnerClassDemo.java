package Lesson05_InnerClass;

public class AnnonymousInnerClassDemo {

    public static void main(String args[]) {

        ACustomer a = new ACustomer("Dany", 2929292327L);
        System.out.println("new Customer");
        ACustomer.Account account1 = a.new Account(2000);
        ACustomer.Account account2 = a.new Account(4000);
        System.out.println("new two accounts");
        System.out.println("account1: " + account1);
        System.out.println("account2: " + account2);
        System.out.println(account1.getNIS());
        System.out.println(account2.Dollar());
        System.out.println("dollar acount");
        ACustomer.Account account1US = account1.getUSADollarAccount(4.0);
        System.out.println("\naccount1US (account1 in US$) is : " + account1US);
        System.out.println("account1US in NIS is : " + account1US.getNIS());

    }
}

class ACustomer {

    private String name;
    private long id;

    public ACustomer(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String toString() {
        return "name : " + name + "  id : " + id;
    }

    class Account {

        double balance;
        long num;

        public Account(double sum) {
            balance = sum;

        }

        public double getNIS() {
            return balance;
        }

        public double Dollar() {
            System.out.println("not dollar account");
            return 0;
        }

        //×�× ×—× ×• ×§×•×¨×�×™×� ×œ×¤×•× ×§×¦×™×” ×©×ž×—×–×™×¨×” ×�×§×�×•× ×˜ ×ž×•×¨×—×‘ ×”×™×� ×�× ×•× ×™×ž×™×ª
        //×�×§×�×•× ×˜ ×™×§×¨×� ×œ×¤×•× ×§×¦×™×” ×©×ž×—×–×™×¨×” ×�×§×�×•× ×˜ ×—×“×© ×©×œ ×“×•×œ×¨×™×�
        public Account getUSADollarAccount(double exchangeRate) {
            return new Account(this.balance / exchangeRate) {
                {
                    System.out.println("Constractor USA Account");
                }

                @Override
                public String toString() {
                    String str = "(This is an Annonymous class)\n";
                    return str + super.toString();
                }

                @Override
                public double Dollar() {
                    return balance;
                }

                @Override
                public double getNIS() {
                    return Account.this.balance;
                }
            };
        }

        ///////////////////////////////////////////////////////
        //class into function exchangeRate final
        ///////////////////////////////////////////////////////////////////////
        public Comparable getUSADollarAccount1(final double exchangeRate) {
            class AccountDollar implements Comparable<Object> {

                @Override
                public int compareTo(Object o) {
                    double z = exchangeRate;
                    return 1;
                }

            }
            return new AccountDollar();
        }
        ///////////////////////////////////////////////////////////////////////

        public Account() {
        }

        public String toString() {
            return "The Account belongs to " + ACustomer.this.name
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    + " and its balance is " + balance;
        }
    }
}
/**
 * OUTPUT: account1: The Account belongs to Dany and its balance is 2000.0
 * account2: The Account belongs to Dany and its balance is 4000.0
 *
 * account1US (account1 in US$) is : (This is an Annonymous class) The Account
 * belongs to Dany and its balance is 480.7692307692308 account1US in NIS is :
 * 2000.0
 */
