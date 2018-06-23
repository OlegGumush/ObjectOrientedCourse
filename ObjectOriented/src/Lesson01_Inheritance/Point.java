package Lesson01_Inheritance;

public class Point extends Shape {

    private double _x, _y;
    public Point(double x1, double y1) {
        //use father default constructor
        super();
        _x = x1;
        _y = y1;
    }

    public Point(double x1, double y1, String color) {
       super(color,true);
        //_color = color;
        _x = x1;
       _y = y1;
    }


    public Point(Point p) {
        super(p.color(),p._fill);
        _x = p.x();
        _y = p.y();
    }

    public double x() {
        return _x;
    }

    public double y() {
        return _y;
    }

    public String toString() {
        return "[" + _x + "," + _y + super.toString();
    }

    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(3,4);
        System.out.println("p1 = "+p1);
        double a = p1.area();
    }
}
