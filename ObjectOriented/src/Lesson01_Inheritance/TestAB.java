package Lesson01_Inheritance;

public class TestAB {

    public static void main(String[] args) {
        B b = new B(6);
        b.fun();
    }
}

class temp {

    protected int x;

   public temp(int x) {
        this.x = x;
        System.out.println("class A-X constructor");;
    }


    public temp() {
        System.out.println("class A constructor");;
    }

    public final void fun() {
        System.out.println("fun");
   }
}

class B extends temp {

    int z;

    public B(int z) {
        super(z);
        this.z = z;
        System.out.println("class B constructor");
    }
}
