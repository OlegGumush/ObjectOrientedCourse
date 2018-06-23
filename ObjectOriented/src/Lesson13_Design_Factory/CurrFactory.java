package Lesson13_Design_Factory;

import java.util.Scanner;

interface Currency {

    String getSymbol();
}
// Concrete Rupee Class code

class Rupee implements Currency {

    @Override
    public String getSymbol() {
        return "RS";
    }
}
// Concrete Shekel class Code

class Shekel implements Currency {

    @Override
    public String getSymbol() {
        return "SH";
    }
}
// Concrete US Dollar code

class USDollar implements Currency {

    @Override
    public String getSymbol() {
        return "USD";
    }
}
// Factory Class code

class CurrencyFactory {

    public static Currency createCurrency(String country) {
        if (country.equalsIgnoreCase("India")) {
            return new Rupee();
        } else if (country.equalsIgnoreCase("Israel")) {
            return new Shekel();
        } else if (country.equalsIgnoreCase("US")) {
            return new USDollar();
        }
        throw new IllegalArgumentException("No such currency");
    }
}

public class CurrFactory {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("get country:  ");
        String country = sc.next();

        //Currency c = CurrencyFactory.createCurrency(country);
        //System.out.println(c.getSymbol());
        System.out.println(CurrencyFactory.createCurrency(country).getSymbol());
        sc.close();
    }
}
