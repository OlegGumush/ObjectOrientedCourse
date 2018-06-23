package Lesson10_FileObjectStream;

import java.io.Serializable;

public class Point extends Shape{//implements Serializable{
	private static final long serialVersionUID = 1L;
	// ******** private data ********
	private double _x, _y;

	// ********* constructors ********
	public Point (double x1, double y1) {
		super();
		_x = x1;
		_y = y1;
	}

	/** copy constructor:
       1)here a direct access to a class member is performed,
         this will be done only in a constructor to achieve an identical copy
       2) using a call to another constructor code is not written twice
	 */
	public Point (Point p) { this(p._x, p._y);}

	// ********** public methodes *********
	public double x() {return _x;}
	public double y() {return _y;}

	/** @return a String contains the Point data*/
//	public String toString()  {
//		return "name: " + this.getClass()+" "+this.getColor() +" [" + _x + "," + _y+"]";
//	}
	public void translate(Point p){
		_x = _x + p.x();
		_y = _y + p.y();
	}
	public static void main(String[] args) {
		Point p1 = new Point(1,2);
		Point p2 = new Point(1,2);
		System.out.println(p1.equals(p2));	
	}

    private boolean equals(Point p2) {
        if(this._x==p2.x()&&this._y==p2.y())return true;
        return false;
    }

}// class Point