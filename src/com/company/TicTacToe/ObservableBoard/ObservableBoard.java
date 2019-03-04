package com.company.TicTacToe.ObservableBoard;

import com.company.TicTacToe.Field.Field;

import java.util.LinkedList;

public class ObservableBoard {

    private final Board board;

    private LinkedList<Observer> observers = new LinkedList<>();

    public ObservableBoard(Board board) {
        this.board = board;
    }

    public void attach(Observer o) {
        observers.add(o);
    }

    public void mark(Field f, Mark m) {
        board.mark(f, m);

        for(int i = 0; i < observers.size(); i++)
            observers.get(i).update();
    }

    public void detach(Observer o) {
        observers.remove(o);
    }
}
