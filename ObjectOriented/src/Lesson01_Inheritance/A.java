package Lesson01_Inheritance;

public class A {
	int var;
	public void f(){
		Shape sh = new Shape("green",false);
		sh._color = "yellow";
		var = 1;
	}
}
