/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson11_Singelton;

public class OlegSingelton {
    private static OlegSingelton instance = null;
    private static int id=0;
    private static String name;
    private OlegSingelton(){
       name ="Oleg";
       id = 319638490;
    }
    
    public static OlegSingelton getinstance(){
        if(instance==null){
            instance =  new OlegSingelton();
            return instance;
        }
        return instance;
    }
    public String toString(){
        return ""+id+ " "+name;
    }
    
}
class main123{
    public static void main(String[] args) {
        OlegSingelton a = OlegSingelton.getinstance();
        System.out.println(a.toString());
        OlegSingelton b = OlegSingelton.getinstance();
        System.out.println(b.toString());

    }
}
