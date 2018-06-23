package Lesson01_Inheritance;

public class Shape {

    //like private 
    //but we can inheritance this variables
    protected String _color;
    protected boolean _fill;

    public Shape() {
        this._color = "black";
        this._fill = false;
    }
    public Shape(String color,boolean fill) {
        this._color = color;
        this._fill = fill;      
    }

    public String color() {
        return this._color;
    }

    public String toString() {
        return "color: " + _color + ", fill = "+_fill;
    }

    public double area() {
        return 0;
    }

    public double perimeter() {
        return 0;
    }
}
