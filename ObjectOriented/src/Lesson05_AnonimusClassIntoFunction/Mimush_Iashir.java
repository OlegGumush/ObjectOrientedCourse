/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson05_AnonimusClassIntoFunction;

/**
 *
 * @author Oleg
 */
public class Mimush_Iashir implements Interface_Chuchi {

    @Override
    public void becomeChuchi() {
        System.out.println("Ahahahaha I am Chuchi Now");
    }

    @Override
    public void disturbChuchi() {
        System.out.println("chu chu chu");
    }

}

class Mimush_Iashir1 implements Comparable<Object> {

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}

class Lo_Mimush_Iashir {

    public static Interface_Chuchi getChuchi() {
        return new Interface_Chuchi() {

            @Override
            public void becomeChuchi() {
                System.out.println("Ahahahaha I am AnonimusChuchi Now");

            }

            @Override
            public void disturbChuchi() {
                System.out.println("chu chu chu");
            }
        };
    }

    public static Comparable getCompare() {
        return new Comparable() {

            @Override
            public int compareTo(Object o) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }

}

class ChuchiMain {

    public static void main(String[] args) {
        //Mimush_Iashir this is a name!!!!!!!!! he not Annomous
        Interface_Chuchi chuchi = new Mimush_Iashir();
        chuchi.becomeChuchi();
        chuchi.disturbChuchi();
        Interface_Chuchi chu = Lo_Mimush_Iashir.getChuchi();
        chu.becomeChuchi();
        chu.disturbChuchi();

        Comparable c = Lo_Mimush_Iashir.getCompare();

    }
}
