package Lesson10_FileObjectStream;

import java.io.Serializable;

public class Shape implements Serializable {

    private static final long serialVersionUID = 1L;
    private String color;

    public Shape() {
        this.color = "black";
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

    public String toString() {
        return "color: " + color;
    }

    public double area() {
        return 0;
    }

    public double perimeter() {
        return 0;
    }
}
