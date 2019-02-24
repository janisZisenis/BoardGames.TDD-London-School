package com.company.IsOnBoardValidatorImp;

import com.company.AlertingValidator.Validator;
import com.company.OnBoardInputGenerator.IsOnBoardValidator;
import com.company.UserInput;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

public class IsOnBoardValidatorImp implements IsOnBoardValidator, Validator {

    private final Board board;

    public IsOnBoardValidatorImp(Board board) {
        this.board = board;
    }

    public boolean isValid(UserInput in) {
        Field f = makeField(in);
        return board.exists(f);
    }

    private Field makeField(UserInput in) {
        int row = in.getRow();
        int column = in.getColumn();

        return new Field(row, column);
    }
}
