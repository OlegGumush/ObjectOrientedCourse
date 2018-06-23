/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson03_Observer_Java;

import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author Oleg
 */
// ממשק קיים בגואה חייב לממש פונקציית רענון
public class Student implements Observer {

    private String name;
    public Student(String name) {
        this.name = name;
    }
    //פונקציה שחייב לממש כי ממשנו ממשק
    //מקבל את לוח המודעות ואובייקט למשל מחרוזת ומעדכנת
    public void update(Observable o, Object arg) {    
        System.out.println(name + ": My Message board changed: " + arg);
    }

}
