/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson03_Exception_Scanner;

/**
 *
 * @author Student
 */
public class TestExceptions {

    public static void arrayIndexOut() {
        int arr[] = {1, 2, 3, 4, 5};
        try {
            for (int i = 0; i <= arr.length; i++) {
                arr[i] = i;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\narray index out of bounds");
            e.printStackTrace();
        }
        for (int v:arr){
            System.out.println("v = "+v);
        }
    }

    public static void main(String[] args) {
        //System.out.println("Math.sqrt(-1) = " + Math.sqrt(-1));
        arrayIndexOut();
        int t = -1;
        //if (t<0) throw new RuntimeException();
        double d = Math.sqrt(t);
        System.out.println("d = "+d);
        double x = 1.0/0.;
        System.out.println("x = "+x);
    }
}
