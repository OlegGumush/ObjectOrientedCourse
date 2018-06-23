/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson03_Observer_My;

import java.util.ArrayList;

/**
 *
 * @author Oleg
 */
public class MyObserevable {
    
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    String Board;

    public String getBoard() {
        return Board;
    }

    public void setBoard(String Board) {
        this.Board = Board;
    }

    //add student
    public void add_Observer(Observer a) {
        observers.add(a);
    }

    public void remove_Observer(Observer a) {
        observers.remove(a);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(this);
        }
    }
}
