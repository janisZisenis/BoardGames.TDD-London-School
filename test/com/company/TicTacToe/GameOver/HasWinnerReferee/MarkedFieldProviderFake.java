package com.company.TicTacToe.GameOver.HasWinnerReferee;

import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Field.Field;

import java.util.HashMap;

public class MarkedFieldProviderFake {

    private static char john = 'J';
    private static char haley = 'H';

    private HashMap<Field, Mark> marks = new HashMap<>();

    public static MarkedFieldProviderFake fromChar(char[][] state) {
        MarkedFieldProviderFake fake = new MarkedFieldProviderFake();

        initialize(state, fake);

        return fake;
    }

    private static void initialize(char[][] state, MarkedFieldProviderFake fake) {
        for(int j = 0; j < state.length; j++)
            for(int i = 0; i < state[j].length; i++)
                if (!isEmpty(state[j][i])) {
                    Field f = new Field(j, i);
                    Mark m = map(state[j][i]);
                    fake.marks.put(f, m);
                }
    }

    private static boolean isEmpty(char c) {
        return c != john && c != haley;
    }

    private static Mark map(char c) {
        return c == john ? Mark.John : Mark.Haley;
    }


    public Mark getMarkAt(Field f) {
        throwIfFieldIsNotMarked(f);

        return marks.get(f);
    }

    private void throwIfFieldIsNotMarked(Field f) {
        if(!isMarked(f))
            throw new Board.FieldIsNotMarked();
    }

    public boolean isMarked(Field f) {
        return marks.containsKey(f);
    }
}
