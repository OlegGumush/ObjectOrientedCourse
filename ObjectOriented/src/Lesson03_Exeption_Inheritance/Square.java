package Lesson03_Exeption_Inheritance;

public class Square extends Rectangle {

    public Square(double edge) throws PolygonException {
        super(edge, edge);
    }

    public double area() {
        double area = 0;
        try {
            area = super.area();
        } catch (PolygonException e) {
            e.printStackTrace();
        }
        return area;
    }

    public static void main(String[] a) {
        Square sq = null;
        try {
            sq = new Square(0);
        } catch (PolygonException e) {
            e.printStackTrace();
        }
        double s = sq.area();
        System.out.println("area = " + s);
    }
}
