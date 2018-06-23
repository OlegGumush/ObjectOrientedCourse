/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson02_Comparable__Interface_Java;

/**
 *
 * @author Oleg
 */
public class Point implements Comparable<Point> {

    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this(p.x, p.y);
    
    }
    // ********** public methodes *********

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    @Override
    public int compareTo(Point p) {
        int ans;
        if (this.distance() > p.distance()) {
            ans = -1;
        } else if (this.distance() < p.distance()) {
            ans = 1;
        } else {
            ans = 0;
        }
        return ans;
    }

    /**
     * @return a String contains the Point data
     */
    @Override
    public String toString() {
        return "name: " + this.getClass() + "[" + x + "," + y + "]";
    }

    /**
     * logical equals
     *
     * @param p other Object (Point).
     * @return true iff p instance of Point && logicly the same)
     */
    public boolean equals(Point p) {
        return p != null && p.x == x && p.y == y;
    }

    public double distance() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

  
}//end

