package Lesson13_Disign_Composite;

/**
 * The following example, written in Java, 
 * implements a graphic class, which can be either 
 * an ellipse or a composition of several graphics. 
 * Every graphic can be printed. In algebraic form,
       Graphic = ellipse | GraphicList
       GraphicList = empty | Graphic GraphicList
 *It could be extended to implement several other shapes 
 *(rectangle, etc.) and methods (translate, etc.).
 */
import java.util.ArrayList;
/** "Component" */
interface Graphic {
	//Prints the graphic.
	public void draw();

}

/** "Composite" */
class CompositeGraphic implements Graphic {
	//Collection of child graphics.
	private ArrayList<Graphic> childGraphics = new ArrayList<Graphic>();
	private String name;
	// constructor
	public CompositeGraphic(String name){
		this.name = name;
	}
	//Prints the graphic.
	public void draw() {
		System.out.println(name);
		for (Graphic graphic : childGraphics) {
			graphic.draw();
		}
		System.out.println();
	}

	//Adds the graphic to the composition.
	public void add(Graphic graphic) {
		childGraphics.add(graphic);
	}

	//Removes the graphic from the composition.
	public void remove(Graphic graphic) {
		childGraphics.remove(graphic);
	}

}
/** "Leaf" */
class Ellipse implements Graphic {
	int number;
	public Ellipse(int n){
		number = n;
	}
	//Prints the graphic.
	public void draw() {
		System.out.println("Ellipse "+number);
	}
}
/** "Leaf" */
class Circle implements Graphic {
	int number;
	public Circle(int n){
		number = n;
	}
	//Prints the graphic.
	public void draw() {
		System.out.println("Circle "+number);
	}
}
class Client{
	public  static void go(){
		//Initialize four ellipses
		Ellipse ellipse1 = new Ellipse(1);
		Ellipse ellipse2 = new Ellipse(2);
		
		Circle circle1 = new Circle(1);
		Circle circle2 = new Circle(2);
		Circle circle3 = new Circle(3);

		//Initialize three composite graphics
		CompositeGraphic graphic1 = new CompositeGraphic("graphic 1");
		CompositeGraphic graphic2 = new CompositeGraphic("graphic 2");
		CompositeGraphic graphic3 = new CompositeGraphic("graphic 3");

		//Composes the graphics
		graphic1 .add(ellipse1);
		graphic1 .add(ellipse2);
		
		graphic2.add(circle1);
		graphic2.add(circle2);
		
		graphic3.add(circle3);
		graphic3.add(graphic1);
		graphic3.add(graphic2);

		//Prints the complete graphic
		graphic3.draw();
		
		//remove
		graphic3.remove(graphic2);
		System.out.println("remove graphic2:");
		graphic3.draw();

		graphic1.remove(ellipse1);
		graphic1.remove(ellipse2);
		System.out.println("remove ellipse 1-2:");
		graphic3.draw();
		
	}
	
}
public class TestComposite {
	/** Client */
	public static void main(String[] args) {
		Client.go();
	}
}
