/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sortable;

/**
 *
 * @author Oleg
 */
public interface Sortable {

    public int compare(Sortable a);
}

class Emploee implements Sortable {

    int id;
    String name;

    public Emploee(int i, String n) {
        id = i;
        name = n;
    }

    @Override
    public int compare(Sortable a) {
        if (a instanceof Emploee) {
            if (this.id > ((Emploee) a).id) {
                return 1;
            } else if (this.id < ((Emploee) a).id) {
                return -1;
            }
            return 0;
        }
        throw new  UnsupportedOperationException();
    }
   
}
 class Sort{
     public static void Sort(Sortable []s){
         for (int i = 0; i < s.length; i++) {
             for (int j = i; j < s.length; j++) {
                 if(s[i].compare(s[j])>0){
                     swap();
                 }
                     
             }
         }
     }

    private static void swap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }
