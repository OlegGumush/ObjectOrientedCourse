package Lesson05_InnerClass;

/**
 * You would define a static inner class when you know that it does not have any
 * relationship with the instance of the enclosing class/top class. If your
 * inner class doesn't use methods or fields of the outer class, it's just a
 * waste of space, so make it static.
 *
 */
public class Inner_Public_Static_Class_Nested {

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.fo();
        //ככה פותחים מחלקה פנימית סטטית
        Outer.Nested nested = new Outer.Nested();
        //Nested n = new Nested(); error
        System.out.println("Outer.y = " + Outer.yy);
        nested.f();
        System.out.println("nested.nx = " + nested.nx);
        System.out.println("after nested.f(): Outer.y = " + Outer.yy);
        //////
        Outer.Inner inner = new Outer().new Inner();
        inner.f();
    }
}//end TestNested

class Outer {

    private int x = 1;
    static int yy;

    void fo() {
        x = 3;
        yy = 99;
    }

    public static class Nested {

        int nx;
        //static int xxx;    not eror!!
        void f() {

            //error because static
            //Outer.this.x=6;
            nx = 8;
            //קורא להם עם שם המחלקה
            yy = -9;
            //לפונקציה רק עם אובייקט מהסוג
            Outer o = new Outer();
            o.fo();
            //fo(); //error
            //x = 56; //error
            

        }
    }
    //מחלקה פנימית שהיא לא סטטית לא יכולה להכיל משתנים סטטיים ולא פונקציות
    public class Inner {

        int z = 0, y = 5;
        //static int xx=0;              //error
        //static void fstat(){int a=0;} //error
        
        void f() {
            z = this.y + Outer.this.x + Outer.yy;//z=5+1-9=-3
            System.out.println("I'm Inner  " + z);
        }
    }
}
