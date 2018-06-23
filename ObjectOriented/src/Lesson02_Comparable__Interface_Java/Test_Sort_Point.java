/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson02_Comparable__Interface_Java;

import java.util.Arrays;

/**
 *
 * @author Oleg
 */
public class Test_Sort_Point {

    public static void main(String[] args) {
        Point p[] = new Point[5];
        p[0] = new Point(1, 2);
        p[1] = new Point(1, 1);
        p[2] = new Point(0, 0);
        p[3] = new Point(4, 2);
        p[4] = new Point(2, 2);
        Arrays.sort(p);
        for (int i = 0; i < p.length; i++) {
            System.out.println(p[i].toString());
        }
    }

}
