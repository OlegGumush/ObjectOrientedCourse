package Lesson11_Reflection;

/*import java.lang.reflect.Constructor;
 import java.lang.reflect.Field;
 import java.lang.reflect.Method;
 import java.lang.reflect.Modifier;
 */
import java.lang.reflect.*;
import java.util.LinkedList;
import java.util.Scanner;

public class ReflectionExample {

    public static void main(String[] args) {
        // Creates an object of type Class which contains the information of 
        // the class Student
        Student student = new Student("Haiim", 1, "Computer Science", 1);
        //Class<?> obj = student.getClass(); also good
        Class<? extends Student> obj = student.getClass();
        System.out.println("package: " + obj.getClass().getPackage().getName());
        System.out.println("super class name: " + obj.getSuperclass().getName());
        System.out.println("class name: " + obj.getName());
        System.out.println("obj.isInterface()? " + obj.isInterface());
        System.out.println("Shape isInterface()? " + Shape.class.isInterface());
        System.out.println("obj.isEnum()? " + obj.isEnum());
        System.out.println("Colors is Enum? " + Colors.class.isEnum());
        System.out.println();
        // getDeclaredFields() returns all the fields of the class.
        Field fields[] = obj.getDeclaredFields();
        System.out.println("Name of the Declared fields");
        for (int i = 0; i < fields.length; i++) {
            String name = fields[i].getName();
            String type = fields[i].getGenericType().toString();
            int mode = fields[i].getModifiers();
            String mods = Modifier.toString(mode);
            System.out.println(name + ", " + type + ", " + mods);
        }
        System.out.println("\nName of the Constructors of the String class");
        Constructor<?> constructors[] = obj.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName() + ",  " + constructors[i]);
        }
        // getMethods() returns all the public methods of the class.
        Method methods[] = obj.getMethods();
        System.out.println("\nName of the Methods");
        for (int i = 0; i < methods.length; i++) {
            String name = methods[i].getName();
            String type = methods[i].getGenericReturnType().toString();
            System.out.println(name + ", " + type);
        }
        
        //Funding the interfaces implemented by the class
        System.out.println();
        Class cl = LinkedList.class;
        Class[] interfaces = cl.getInterfaces();
        for (Class cInterface : interfaces) {
            System.out.println(cInterface.getName());
        }
        System.out.println();
        try {
            // Create an instance of a class whose name is not known until runtime
            //Scanner sc = new Scanner(System.in);
            //System.out.println("get class name: ");
            //String s = sc.nextLine();
            Class c = Class.forName("Lesson11_Reflection.Student");

            Object o = c.newInstance();
            if (o instanceof Student) {
                System.out.println(((Student) o).toString());
            }
            System.out.println(c.getName());
            //Methods getMethod () and getMethod () return only the public methods, 
            //in order to get all the methods of the class regardless of the type of access, 
            //you need make use of methods  getDeclaredMethod () and getDeclaredMethods ()
            methods = c.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                String name = methods[i].getName();
                String type = methods[i].getGenericReturnType().toString();
                System.out.println(name + ", " + type);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
