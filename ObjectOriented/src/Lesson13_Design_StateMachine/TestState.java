package Lesson13_Design_StateMachine;

import java.util.Scanner;

interface State {

    public void doAction();
}

class TVStartState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned ON\n");
    }
}

class TVStopState implements State {

    @Override
    public void doAction() {
        System.out.println("TV is turned OFF\n");
    }
}

class TVChannel_1_State implements State {

    @Override
    public void doAction() {
        System.out.println("TV state: channel 1\n");
    }
}

class TVChannel_2_State implements State {

    @Override
    public void doAction() {
        System.out.println("TV state: channel 2\n");
    }
}

class TVContext {

    private State tvState;

    public void setState(State state) {
        this.tvState = state;
    }

    public State getState() {
        return this.tvState;
    }

    public void doAction() {
        this.tvState.doAction();
    }
}

class Menu {

    private final State[] states = {new TVStartState(), new TVStopState(),
        new TVChannel_1_State(), new TVChannel_2_State()};
    Scanner sc = new Scanner(System.in);

    public State getState() {
        System.out.println("menu: 0 - start, 1 - stop, 2 - channel 1, 3 - channel 2, any other number to exit \nget state:");
        int menu = sc.nextInt();
        if (menu > 3 || menu < 0) {
            return null;
        }
        return states[menu];
    }
}

public class TestState {

    public static void main(String[] args) {

        TVContext context = new TVContext();
        Menu menu = new Menu();
        State s = new TVStartState();
        do {
            context.setState(s);
            context.doAction();
            s = menu.getState();
        } while (s != null);


    }
}
