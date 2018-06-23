/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson11_Singelton;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oleg
 */
public class main {
    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                Singleton_A a = Singleton_A.getInstance();
            }
        };
        Thread t = new Thread(r);
        Thread t1 = new Thread(r);
        t.start();
        t1.start();
        
        Singleton_A u = Singleton_A.getInstance();
        System.out.println(u.toString());

    }
}
