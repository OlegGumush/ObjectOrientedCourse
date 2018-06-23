package Lesson01_Inheritance;

public class Circle extends Shape {

    public Point _center;
    public double _radius;
    protected static int counter = 0;

    public Circle(Point p, double radius, String color) {
        super(color, false);
        //_color = color;
        _center = new Point(p.x(), p.y(), color);
        _radius = radius;
    }

    public Circle() {
        //Super() Shape Has Constractor Empty
        counter++;
    }

    public Circle(Point p, double radius) {
        //Super() Shape Has Constractor Empty
        _center = new Point(p);
        _radius = radius;
    }

    public Circle(String color, boolean fill) {
        super(color, fill);
        _center = new Point(0, 0);
        _radius = 1;
    }

    public Circle(Circle c) {
        super(c.color(), c._fill);
        _center = new Point(c._center);
        _radius = c._radius;
    }

    Point p() {
        return _center;
    }

    double r() {
        return _radius;
    }

    public double area() {
        return Math.PI * Math.pow(_radius, 2);
    }

    public double perimeter() {
        return 2 * Math.PI * _radius;
    }

    public String toString() {
        return "center: " + _center.toString() + ", radius: " + _radius + ", " + super.toString();
    }

    public static void main(String[] args) {
        Point p = new Point(3, 4);
        Point p1 = new Point(6, 8);
        Circle cr = new Circle(p, 1, "red");
        Circle cr0 = new Circle("blue", true);
        Circle cr1 = new Circle(p1, 8);
        System.out.println(cr.toString());
        System.out.println(cr0.toString());
        System.out.println(cr1.toString());
        System.out.println("");
        System.out.println("cr.area = " + cr.area());
        System.out.println("cr.perimeter = " + cr.perimeter());

    }
}
