package Lesson04_Iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class SimpleIterator {

    public static void main(String[] args) {
        ArrayList<Character> aList = new ArrayList<>();
        aList.add('a');
        aList.add('b');
        aList.add('c');
        aList.add('d');
        aList.add('a');
        aList.add('b');
        aList.add('c');
        aList.add('d');
        //מחזיר לי איטרטור של אריי ליסט
        Iterator<Character> aIter = aList.iterator();
        aIter.next();
        aIter.next();
        aIter.next();
        aIter.next();
        aIter.next();
        aIter.next();
        aIter.remove();
        aIter.remove();

        aIter = aList.iterator();
        while (aIter.hasNext()) {
            System.out.print(aIter.next() + ", ");
        }
        System.out.println("");
        aIter.remove();
        aIter = aList.iterator();
        while (aIter.hasNext()) {
            System.out.print(aIter.next() + ", ");
        }
        System.out.println();
        LinkedList<String> linkList = new LinkedList<>();
        linkList.add("x");
        linkList.add("y");
        linkList.add("z");
        linkList.add("w");
        Iterator<String> linkIter = linkList.iterator();
        while (linkIter.hasNext()) {
            System.out.print(linkIter.next() + ", ");
        }
        //אם נעשה את השורה הזאת התוכנית תקרוס כי הגענו לסוף הרשימה ואנחנו מנסים לקחת עוד איבר בלי שבדקנו אם הגענו לסוף
        //System.out.println(linkIter.next());
        System.out.println();
        //Integer []arr = {1,2,3};// no iterator
    }
}
