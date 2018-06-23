package Lesson04_Gineric_Function;

import java.util.ArrayList;
public class UsingWildCards {
	
/** Oracle Documentation: constructor
    ArrayList(Collection<? extends E> c) 
    Constructs a list containing the elements of the specified collection, 
    in the order they are returned by the collection's iterator.
*/
	/**
         * very!!! important ask Elizabeet
         * @param list 
         */
	public static void print1(ArrayList<?> list){
		System.out.println(list.toString());
	}
        
	/**
         * function gets only list that extends Number 
         * @param list
         */
	public static void print2(ArrayList<? extends Number> list){
		System.out.println(list.toString());
	}
	
	public static void main(String[] args) {
		ArrayList<Number> listN = new ArrayList<Number>();
		listN.add(1);
		listN.add(3.14);
		print2(listN);
                
		ArrayList<Integer> listI = new ArrayList<Integer>();
		listI.add(1);
		listI.add(2);
		print2(listI);
                
		ArrayList<Double> listD = new ArrayList<Double>();
		listD.add(1.98);
		listD.add(2.72);
		print2(listI);
                
		ArrayList<String> listS = new ArrayList<String>();
		listS.add("1.98");
		listS.add("2.72");
		//print2(ListS); //error!
		
                ArrayList<String> listSt = new ArrayList<String>();
		listS.add("1.98");
		listS.add("2.72");
		print1(listSt);
                

	}
}
