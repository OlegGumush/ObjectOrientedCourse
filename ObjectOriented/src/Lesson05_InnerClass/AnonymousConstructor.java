package Lesson05_InnerClass;

abstract class Base {

    public Base(int i) {
        System.out.println("Base constructor, i = " + i);
    }

    public abstract void f();

}

public class AnonymousConstructor {

    public static Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("Inside instance initializer");
            }

            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

}

class AnonymousConstructor________NoStatic {

    public Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("Inside instance initializer");
            }

            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

}

class Main2 {

    public static void main(String[] args) {
        
        Base base = AnonymousConstructor.getBase(47);
        base.f();
        
        
        AnonymousConstructor________NoStatic a=new AnonymousConstructor________NoStatic();
        Base base1=a.getBase(7);
        base1.f();
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
    }
}
