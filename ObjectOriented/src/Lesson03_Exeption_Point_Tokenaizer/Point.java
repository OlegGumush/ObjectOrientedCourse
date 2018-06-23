package Lesson03_Exeption_Point_Tokenaizer;

import java.util.StringTokenizer;



public final class Point {

    private double _x, _y;  // we "mark" data members using _. 

    public Point(double x1, double y1) {
        _x = x1;
        _y = y1;
    }
    public Point(Point p) {
        _x = p.x();
        _y = p.y();
    }
    public double x() {
        return _x;
    }

    public double y() {
        return _y;
    }
    
    @Override
    public String toString() {
        return "[" + _x + "," + _y + "]";
    }
    //safe constractor 
    //get string and check if the string is point
    //if null throw exeption or if num of param !=2
    //this exceptions we extends from class NullException
    //or extends from FormatExeption Java
    public Point(String str) throws NullException, NumberFormatException {
        if (str == null) {
            throw new NullException(" PointException: Point is null!!!");
        }
        StringTokenizer st = new StringTokenizer(str, "[,]");
        int ct = st.countTokens();
        if (ct != 2) {
            throw new NumberFormatException(" PointException: " + str + " Point has " + ct + " coordinates instead of 2  ");
        }
        _x = Double.parseDouble(st.nextToken()); //(new Double(st.nextToken()).doubleValue());
        _y = (new Double(st.nextToken()).doubleValue());
    }
}// class Point