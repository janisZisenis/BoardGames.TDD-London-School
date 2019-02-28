package com.company.TicTacToe.FieldIsEmptyValidator;

import com.company.TicTacToe.Field;
import java.util.Arrays;

public class FieldIsEmptyProviderStub implements FieldIsEmptyProvider {
    private Field[] occupied = {};

    public boolean isEmpty(Field field) {
        return !OccupiedFieldsContain(field);
    }

    private boolean OccupiedFieldsContain(Field field) {
        return Arrays.asList(occupied).contains(field);
    }

    public void setOccupiedFields(Field[] occupied) {
        this.occupied = occupied;
    }
}
