/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson13_Design_Factory;

import java.util.Scanner;

/**
 *
 * @author Oleg
 */
public class KatyFactory {
    
    public static perfume getPerfume(String notice){
        if(notice.equalsIgnoreCase("D"))
            return new DKNY();
        else if(notice.equalsIgnoreCase("H"))
            return new Hermess();
        return null;
    }
    
}
abstract class perfume{
    String name;
    int price;
    public perfume(String n , int p){
        name = n;
        price=p;
    }
    abstract public void work();
    abstract public void smell();
}
class DKNY extends perfume{

    public DKNY(){
        super("DKNY",300);
    }
    @Override
    public void work() {
        System.out.println("ps ps ps");
    }

    @Override
    public void smell() {
        System.out.println("apple");
    }

    @Override
    public String toString() {
        return "DKNY{" + '}';
    }
    
    
}
class Hermess extends perfume{

    public Hermess(){
        super("Hermess",600);
    }
    @Override
    public void work() {
        System.out.println("sh sh sh");
    }

    @Override
    public void smell() {
        System.out.println("Toilet");
    }

    @Override
    public String toString() {
        return "Hermess{" + '}';
    }
    
    
}
class Katy{
    public static void main(String[] args) {
        
        perfume p = KatyFactory.getPerfume("H");
        System.out.println(p.name);
        p.smell();
        p.work();
    }
}