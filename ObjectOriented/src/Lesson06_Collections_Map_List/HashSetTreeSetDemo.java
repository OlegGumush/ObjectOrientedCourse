package Lesson06_Collections_Map_List;

import java.awt.Point;
import java.util.HashSet;
import java.util.TreeSet;

public class HashSetTreeSetDemo {

    public static void HS_Demo() {
        Point p = new Point(34, 3);
        Point p1 = new Point(2, 3);
        Point p2 = new Point(3, 3);
        Point p3 = new Point(34, 3);
        Point p4 = new Point(34, 3);
        Point p5 = new Point(34, 3);
        Point arr[] = new Point[6];
        arr[0] = p;
        arr[1] = p1;
        arr[2] = p2;
        arr[3] = p3;
        arr[4] = p4;
        arr[5] = p5;
        HashSet<Point> points = new HashSet<Point>();
        for (int i = 0; i < arr.length; i++) {
            points.add(arr[i]);
        }
        System.out.println(points.toString());

        //מוסיף בלי כפילויות וממוין
        HashSet<Integer> setA = new HashSet<Integer>();
        setA.add(3);
        setA.add(5);
        setA.add(8);
        setA.add(2);
        setA.add(3);
        setA.add(5);
        setA.add(8);
        setA.add(2);
        System.out.println("setA: " + setA.toString());

        HashSet<Integer> setB = new HashSet<Integer>();
        setB.add(1);
        setB.add(7);
        setB.add(3);
        setB.add(9);
        setB.add(2);
        setB.add(2);
        setB.add(2);
        System.out.println("setB: " + setB);

        //Set union
        //בעזרת פונקציה פשוטה ממזג וממיין
        HashSet<Integer> unionSet = new HashSet<Integer>(setA);
        //unionSet.addAll(setA);
        unionSet.addAll(setB);
        System.out.println("A union B: " + unionSet);

        //Set intersection
        //חיתוך של שתי סטים  
        HashSet<Integer> interSet = new HashSet<Integer>(setA);
        interSet.retainAll(setB);
        System.out.println("A intersection B: " + interSet);

        //Set difference A - B
        HashSet<Integer> diffSet = new HashSet<Integer>(setA);
        diffSet.removeAll(setB);
        System.out.println("A - B: " + diffSet);

        //מוסיף מחרוזות לא ממוין אבל בלי כפילויות
        HashSet<String> hashStr = new HashSet<String>();
        hashStr.add("x");
        hashStr.add("a");
        hashStr.add("c");
        hashStr.add("a");
        System.out.println("Hash Strings: " + hashStr);
    }

    public static void TS_Demo() {


        TreeSet<Integer> treeA = new TreeSet<Integer>();

        treeA.add(5);
        treeA.add(8);
        treeA.add(2);
        treeA.add(3);
        System.out.println("setA: " + treeA);

        TreeSet<Integer> treeB = new TreeSet<Integer>();
        treeB.add(1);
        treeB.add(7);
        treeB.add(3);
        treeB.add(9);
        System.out.println("setB: " + treeB);

        //TreeSet union
        TreeSet<Integer> unionTree = new TreeSet<Integer>(treeA);
        unionTree.addAll(treeB);
        System.out.println("A union B: " + unionTree);

        //TreeSet intersection
        TreeSet<Integer> interTree = new TreeSet<Integer>(treeA);
        interTree.retainAll(treeB);
        System.out.println("A intersection B: " + interTree);

        //TreeSet difference A - B
        HashSet<Integer> diffTree = new HashSet<Integer>(treeA);
        diffTree.removeAll(treeB);
        System.out.println("A - B: " + diffTree);
       
        //tree set sort strings
        TreeSet<String> treeStr = new TreeSet<String>();
        treeStr.add("aa");
        treeStr.add("xx");
        treeStr.add("cc");
        treeStr.add("bb");
        System.out.println("Set Strings: " + treeStr);
    }

    public static void main(String args[]) {
        System.out.println("HashSet DEMO");
        HS_Demo();
        System.out.println("\nTreeSet DEMO");
        TS_Demo();
        /*SortedSet s = Collections.synchronizedSortedSet(new TreeSet());
         Set s1 = Collections.synchronizedSet(new HashSet());
         SortedMap m = Collections.synchronizedSortedMap(new TreeMap());
         Map m1 = Collections.synchronizedSortedMap(new TreeMap());
         */    } // end main
} // end class HashSetDemo
