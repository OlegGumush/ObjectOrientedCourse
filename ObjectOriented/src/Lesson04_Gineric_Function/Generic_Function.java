package Lesson04_Gineric_Function;

//all numbers Integer Double .... inherited from Number
// Integer arr[i]=new Number //ERROR
// Double 7 = Integer 7 //False
// int 7 == double 7.00 //true
import java.util.ArrayList;

public class Generic_Function {

    public static <T> boolean isInT(T x, T[] arr) {
        for (T val : arr) {
            if (x.equals(val)) {
                return true;
            }
        }
        return false;
    }

    public static <T, V> boolean isInTV(T x, V[] arr) {
        for (V val : arr) {
            if (x.equals(val)) {
                return true;
            }
        }
        return false;
    }
//  Number x; v Integer

    public static <T, V extends T> boolean isInTVEx(T x, V[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (x.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }
    // A list declared to hold objects of a type T can also hold objects that extend from T.
    // Double, Integer, Float, . . inherit the Number

    public static <T extends Comparable<T>,V extends Thread> boolean isInTVEx(T x, V[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (x.equals(arr[i])) {
                return true;
            }
        }
        return false;
    }

    public static void checkInheritance() {

        ArrayList<Number> numlist = new ArrayList<Number>();
        numlist.add(123);
        numlist.add(12.3);
        //numlist.add(new String("abc")); //Error
        for (Number val : numlist) {
            if (val instanceof Integer) {
                int x = (int) numlist.get(0);
                System.out.println("integer x = " + x);
            } else if (val instanceof Double) {
                double x = (Double) val;
                System.out.println("double x = " + x);
            }
        }
        System.out.println(numlist);
        ArrayList<Integer> numlist2 = new ArrayList<Integer>();
        //Number num = 3;
        //numlist2.add(num);//error
    }

    public static void main(String args[]) {

        Integer nums[] = {1, 2, 3, 4, 5};
        int t = 2;
        String strs[] = {"one", "two", "three", "four", "five"};
        ////////// isInT on numbers
        System.out.println("2 is in nums? " + isInT(2, nums));//true
        System.out.println("7 is in nums? " + isInT(7, nums));//false
        System.out.println();
        //////////isInT on Strings
        System.out.println("two is in strs? " + isInT("two", strs));//true
        System.out.println("seven is in strs? " + isInT("seven", strs));//false
        System.out.println("two is in nums? " + isInT("2", nums));
        System.out.println();

        //////////isIn<T,V> on numbers
        t = 2;
        System.out.println("2 is in nums? " + isInTV(t, nums));
        System.out.println("7 is in nums? " + isInTV(7, nums));
        System.out.println("abc is in nums? " + isInTV("abc", nums));
        System.out.println();

        //////////isInTV on Strings
        System.out.println("two is in strs? " + isInTV("two", strs));
        System.out.println("seven is in strs? " + isInTV("seven", strs));
        System.out.println("two is in nums? " + isInTV("two", nums));
        System.out.println();

        //////////isInTV on Number (Integer extends Number, Double extends Number)
        Number x = 2, y = 6, t1 = 2.0;
        Integer numbers[] = {1, 2, 3, 4, 5};
        System.out.println("2 is in numbers? " + isInTVEx(x, numbers));
        System.out.println("6 is in numbers? " + isInTVEx(y, numbers));
        System.out.println("2.0 is in numbers? " + isInTVEx(t1, numbers));
        System.out.println();
        //////////
        boolean b = (2.0 == 2);
        System.out.println("b=" + b);
        Integer u = 2;
         //        int ui = 1;
        //        u = ui;
        Double w = 2.;
        b = u.equals(w);
        System.out.println("b=" + b);

        ///////////
        System.out.println("Check Inheritance:");
        checkInheritance();
    }
}
