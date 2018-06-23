package Lesson10_FileObjectStream;

import Lesson10_FileObjectStream.Shape;
import Lesson10_FileObjectStream.Point;
import Lesson10_FileObjectStream.Point;
import java.io.Serializable;

public class Rectangle extends Shape {// implements Serializable{

    private static final long serialVersionUID = 1L;
    public static String s = "check";
    Point _p1, _p2;

    public Rectangle(Point p1, Point p2) {
        double x1min = Math.min(p1.x(), p2.x());
        double x1max = Math.max(p1.x(), p2.x());
        double y1min = Math.min(p1.y(), p2.y());
        double y1max = Math.max(p1.y(), p2.y());
        _p1 = new Point(x1min, y1min);
        _p2 = new Point(x1max, y1max);
    }

    public Rectangle(Rectangle r) {//deep copy semantic!
        this(r._p1, r._p2);
    }

    public Point p1() {
        return _p1;
    }

    public Point p2() {
        return _p2;
    }

    public double dx() {
        return _p2.x() - _p1.x();
    }

    public double dy() {
        return _p2.y() - _p1.y();
    }

//    public String toString() {
//        return "name: " + this.getClass() + "[" + _p1 + "," + _p2 + "]";
//    }

    public boolean equals(Rectangle r) {
        return r != null && _p1.equals(r._p1) && _p2.equals(r._p2);
    }

    public double perimeter() {
        return ((Math.abs(dy()) * 2) + (Math.abs(dx()) * 2));
    }

    public double area() {
        return Math.abs(this.dy() * this.dx());
    }

    public void translate(Point p) {
        if (p != null && _p1 != null && _p2 != null) {
            _p1.translate(p);
            _p2.translate(p);
        }
    }

    public boolean contains(Point p) {
        boolean ans = false;
        if ((p.x() >= _p1.x()) && (p.x() <= _p2.x()) && (p.y() >= _p1.y()) && (p.y() <= _p2.y())) {
            ans = true;
        }
        return ans;
    }

    public static void printStaticFunction() {
        System.out.println("I'm a static function");
    }

    public void printStaticVariable() {
        System.out.println("I'm a static variable " + s);
    }
}
