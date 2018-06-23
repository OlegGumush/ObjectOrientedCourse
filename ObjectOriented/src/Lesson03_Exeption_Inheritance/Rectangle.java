package Lesson03_Exeption_Inheritance;

public class Rectangle {

    double width, height;

    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }

    public Rectangle(double width, double height) throws PolygonException {
        if (width == 0 || height == 0) {
            throw new PolygonException("(width==0 || height==0");
        }
        this.width = width;
        this.height = height;
    }

    public double area() throws PolygonException {
        if (width == 0 || height == 0) {
            throw new PolygonException("area null");
        }
        double sq = width * height;
        return sq;
    }
}
