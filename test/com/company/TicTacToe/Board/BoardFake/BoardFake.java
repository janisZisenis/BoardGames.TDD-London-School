package com.company.TicTacToe.Board.BoardFake;

import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Field.Field;

import java.util.HashMap;

public class BoardFake {

    private static char john = 'J';
    private static char empty = '.';

    private HashMap<Field, Mark> marks = new HashMap<>();

    public static BoardFake fromChar(char[][] state) {
        BoardFake fake = new BoardFake();

        if(state.length == 1)
            for(int i = 0; i < state[0].length; i++)
                if (!isEmpty(state[0][i]))
                    fake.marks.put(new Field(0, i), map(state[0][i]));

        return fake;
    }

    private static boolean isEmpty(char c) {
        return c == empty;
    }
    private static Mark map(char c) {
        return c == john ? Mark.John : Mark.Haley;
    }

    public boolean isEmpty(Field f) {
        return !marks.containsKey(f);
    }

    public Mark getMarkAt(Field f) {
        if(isEmpty(f))
            throw new Board.FieldIsNotMarked();
        return marks.get(f);
    }

}
