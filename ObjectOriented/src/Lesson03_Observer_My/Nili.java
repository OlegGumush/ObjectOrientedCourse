/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson03_Observer_My;

/**
 *
 * @author Oleg
 */
class Nili implements Observer{
	private String name;
	private String messege;
	public Nili (String name)  {
		this.name = name;
	}
	public void update(MyObserevable Board){
		messege = Board.getBoard();
		System.out.printf("Observer %s's new state is: %s\n", name, messege );
	}
}
