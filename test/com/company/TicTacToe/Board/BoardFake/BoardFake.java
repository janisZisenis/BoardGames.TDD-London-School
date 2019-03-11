package com.company.TicTacToe.Board.BoardFake;

import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Field.Field;

import java.util.HashMap;

public class BoardFake {

    private static char john = 'J';
    private static char haley = 'H';

    private HashMap<Field, Mark> marks = new HashMap<>();

    public static BoardFake fromChar(char[][] state) {
        BoardFake fake = new BoardFake();

        initialize(state, fake);

        return fake;
    }

    private static void initialize(char[][] state, BoardFake fake) {
        for(int j = 0; j < state.length; j++)
            for(int i = 0; i < state[j].length; i++)
                if (!isEmpty(state[j][i])) {
                    Field f = new Field(j, i);
                    Mark m = map(state[j][i]);
                    fake.mark(f, m);
                }
    }

    private static boolean isEmpty(char c) {
        return c != john && c != haley;
    }

    private static Mark map(char c) {
        return c == john ? Mark.John : Mark.Haley;
    }



    public boolean isEmpty(Field f) {
        return !marks.containsKey(f);
    }

    public Mark getMarkAt(Field f) {
        throwIfFieldIsNotMarked(f);

        return marks.get(f);
    }

    private void throwIfFieldIsNotMarked(Field f) {
        if(isEmpty(f))
            throw new Board.FieldIsNotMarked();
    }

    public int getMarkedFieldCount() {
        return marks.size();
    }

    public void mark(Field f, Mark m) {
        marks.put(f, m);
    }
}
