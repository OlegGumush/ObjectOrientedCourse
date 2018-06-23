package Lesson11_Reflection;
import java.lang.reflect.Field;

public class ModifyngPrivateFields {

    public static void main(String[] args) throws Exception {
        WithPrivateFinalField pf = new WithPrivateFinalField();
        System.out.println(pf);
        Field f = pf.getClass().getDeclaredField("i");
        //Oleg Test
        /////////////////////////////////////////////////////////
        //return array of variables
        Field Oleg[] = pf.getClass().getDeclaredFields();  
        for (Field i : Oleg) {
            System.out.println("Oleg Test");
            System.out.println(i.getName());          
        }
        Oleg[0].setAccessible(true);
        Oleg[0].setInt(pf, 7);
        System.out.println("change private to 7"+pf);
        
        Class o = pf.getClass();
        
        
        /////////////////////////////////////////////////////////////
        f.setAccessible(true);
        f.setInt(pf, 47);
        System.out.println(pf);

        final Field f1 = pf.getClass().getDeclaredField("s");
        f1.setAccessible(true);
        f1.set(pf, "MODIFY S");
        System.out.println(pf.toString());


        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        f.set(pf, "MODIFY S2");
        System.out.println(pf);
        //////////////
        Class<?> c = pf.getClass();
        Field fields[] = c.getDeclaredFields();
        String s = fields[0].getName();
        f = pf.getClass().getDeclaredField(s);
        f.setAccessible(true);
        f.setInt(pf, -999);
        System.out.println(pf);
    }
}
