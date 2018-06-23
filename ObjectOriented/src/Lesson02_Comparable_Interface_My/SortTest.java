/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson02_Comparable_Interface_My;

/**
 *
 * @author Oleg
 */
public class SortTest {

    public static void main(String[] args) {
// create an array of Employees, print them, sort them, and print them again
        Sortable[] people = new Sortable[5];
        Sortable s = new Emploee(444556666, "Haim", "Haimovich", 75000);
        people[0]=s;
        people[1] = new Emploee(222334444, "Moshe", "Moshkovich ", 64000);
        people[2] = new Emploee(888776666, "Izhak", "Izhaki ", 67000);
        people[3] = new Emploee(555667777, "Tomer ", "Tamir ", 84000);
        people[4] = new Emploee(555668888, "Sarah ", "Mordehai ", 84000);
        System.out.println("Values before sorting:");
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
       
        
        Sort.bubbleSort(people);
        System.out.println("Values after sorting:");
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }
    }
}

