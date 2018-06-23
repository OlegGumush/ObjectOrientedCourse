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
public class Emploee implements Sortable {

    private int sum;
    private String firstname;
    private String lastname;
    private int salary;

    public Emploee() {
    }

    public Emploee(int SSN, String first, String last, int sal) {
        sum = SSN;
        firstname = first;
        lastname = last;
        salary = sal;
    }
// compare function required by Sortable interface
// orders Employees by social security number

    @Override
    public int compare(Sortable another){
        //return ((Emploee) this).sum - ((Emploee) another).sum;
        if(another instanceof Emploee){
            return this.salary - ((Emploee)another).salary;
        }else
            return -1000;
    }
// allows us to print an Employee

    @Override
    public String toString() {
        String emp;
        emp = Integer.toString(sum) + " " + lastname + " "
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                + firstname + " " + Integer.toString(salary);
        return emp;
    }

} // end class Employee

