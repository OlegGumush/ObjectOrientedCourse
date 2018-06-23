/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson11_Reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 *
 * @author Oleg
 */
public class OlegReflection {

    public static void main(String[] args) {
        Class reflecClass = Oleg.class;
        String className = reflecClass.getName();
        System.out.println("class name " + className);
        int classModifaer = reflecClass.getModifiers();
        System.out.println(classModifaer);
        System.out.println("If class Synchronized " + Modifier.isSynchronized(classModifaer));
        System.out.println("If class Public " + Modifier.isPublic(classModifaer));
        System.out.println("If class isPrivate " + Modifier.isPrivate(classModifaer));
        System.out.println("If class Synchronized " + Modifier.isSynchronized(classModifaer));
        System.out.println("If class Synchronized " + Modifier.isSynchronized(classModifaer));
        System.out.println("If class Synchronized " + Modifier.isSynchronized(classModifaer));

        Class[] Interfases = reflecClass.getInterfaces();
        System.out.println(Arrays.toString(Interfases));
        
        Class classSuper = reflecClass.getSuperclass();
        System.out.println(classSuper.getName());
        
        Method[] methods = reflecClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.print(methods[i].getName()+", ");
        }
       
    }
}

class Oleg implements Runnable,Cloneable{

    private int id;
    private String name;

    public Oleg() {
        id = 319638490;
        name = "Oleg";
    }

    public int getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
