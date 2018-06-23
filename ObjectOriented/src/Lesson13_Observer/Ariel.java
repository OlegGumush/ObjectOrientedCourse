
package Lesson13_Observer;

import java.util.ArrayList;

/**
 *
 * @author Oleg
 */
//like java if we want java need import
interface Observable {

    public void registerStudent(Observer a);

    public void unRegisterStudent(Observer a);

    public void updateAll();
}

public class Ariel implements Observable {

    ArrayList<Observer> ariel = new ArrayList();
    String massage = "";

    @Override
    public void registerStudent(Observer a) {
        ariel.add(a);
    }
    public void setMassage(String s){
        massage = s;
    }
    @Override
    public void unRegisterStudent(Observer a) {
        ariel.remove(a);
    }

    @Override
    public void updateAll() {
        for (int i = 0; i < ariel.size(); i++) {
            ariel.get(i).update(this, massage);
        }
    }

}

interface Observer {

    public void update(Observable o, String massage);
}

class Studentt implements Observer {

    String name;
    int id;
    static int count;

    public Studentt(String n, int id,Ariel a) {
        name = n;
        this.id = id;
        count++;
        a.registerStudent(this);
    }

    @Override
    public void update(Observable o, String massage) {
        System.out.println(name + " get massage " + massage);
    }
}

class University {

    public static void main(String[] args) {
        Ariel a = new Ariel();
        Studentt s = new Studentt("Katy", 319638490,a);
        Studentt s1 = new Studentt("Oleg", 319638490,a);
        Studentt s2 = new Studentt("Itai", 319638490,a); 
        a.setMassage("Gotlib seek");
        a.updateAll();
        Studentt s3 = new Studentt("Sasi", 00000,a);
        a.setMassage("Sasi Hadash be Happy");
        a.updateAll();
    }
}
