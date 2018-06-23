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
interface Ship{
    public void size();
    public void speed();
}
class BigShip implements Ship{

    public BigShip(){
        System.out.println("Creat a bigShip");
        size();
        speed();
    }
    @Override
    public void size() {
        System.out.println("Big");
    }

    @Override
    public void speed() {
        System.out.println("Slow");
    }
    
}
class SmallShip implements Ship{

    public SmallShip(){
        System.out.println("Creat a SmallShip");
        size();
        speed();
    }
    @Override
    public void size() {
        System.out.println("Small");
    }

    @Override
    public void speed() {
        System.out.println("Fast");
    }
    
    
}
public class ShipFactory {
    
    public static Ship getShip(String type){
        if(type.equalsIgnoreCase("B"))
            return new BigShip();
        else if(type.equalsIgnoreCase("S"))
            return new SmallShip();
        return null;
    }
}
class Main{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please Choose ship B-Big,S-Small");
        String choose = s.nextLine();
        ShipFactory.getShip(choose);
        
        
    }
}
