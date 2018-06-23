/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson03_Exeption_Symbol;

/**
 *
 * @author Oleg
 */
public class Symbol
{
	private String name;
	private int value;
	public Symbol(String n, int v){
		this.name = n;
		this.value = v;
	}
	public Symbol(Symbol sym){
		this.name = sym.name;
		this.value = sym.value;
	}
	public boolean equals(Symbol sym){
		boolean ans = false;
		if (this.name==sym.name && this.value==sym.value) ans = true;
		return ans;
	}

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }
        
}