package Lesson08_Threads;
public class Point{
	private double x,y;            
	public Point (double x1, double y1){
		x = x1;
		y = y1;
	}
	public Point (){
		x = 0;
		y = 0;
	}
 // ********** public methods *********
	public double getX() {
		return x;
	}	
	public double getY() {
		return y;
	}

    public void  setX(double x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

    public void setY(double y) {
        this.y = y;
    }
	public double distance() {
		return Math.sqrt(this.x*this.x + this.y*this.y);
	}
}
