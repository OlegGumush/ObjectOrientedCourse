package Lesson13_Disign_Composite;

import java.util.ArrayList;

// Define a "lowest common denominator"
interface AbstractFile{//Component
	public void ls();
}

// File implements the "lowest common denominator"
class MyFile implements AbstractFile{
	private String fileName;
	public MyFile(String name){
		fileName = name;
	}
	public void ls(){
		System.out.println(CompositeDemo.level + fileName);
	}
}

// Directory implements the "lowest common denominator"
class Directory implements AbstractFile{//Composite
	private String dirName;
	private ArrayList<Object> files = new ArrayList<Object>();
	public Directory(String name){
		dirName = name;
	}
	public void add(Object obj){
		files.add(obj);
	}
	public void ls(){
		System.out.println(CompositeDemo.level + dirName);
		CompositeDemo.level.append("  ");
		for (int i = 0; i < files.size(); ++i){
			// Leverage the "lowest common denominator"
			AbstractFile obj = (AbstractFile)files.get(i);
			obj.ls();
		}
		CompositeDemo.level.setLength(CompositeDemo.level.length()-2);
	}
}

public class CompositeDemo{
	public static StringBuffer level = new StringBuffer();

	public static void main(String[] args){
		Directory one = new Directory("dir_1"),  
				  two = new Directory("dir_2"), 
				  three = new Directory("dir_3");
		MyFile 	a = new MyFile("aa"), b = new MyFile("bb"), c = new MyFile("c"), 
				d = new MyFile("d"), e = new MyFile("e"),f = new MyFile("e");
		one.add(a);
		one.add(two);
		one.add(b);
		one.add(f);
		two.add(c);
		two.add(d);
		two.add(three);
		three.add(e);
		one.ls();
		System.out.println();
		two.ls();
		System.out.println();
		a.ls();
	}
}
