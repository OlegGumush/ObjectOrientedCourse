/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson11_Singelton;

/**
 *
 * @author Oleg
 */
public class Person {
     static int  num =0;
    public Person(){
        num++;
    }
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        
        
    }
}
