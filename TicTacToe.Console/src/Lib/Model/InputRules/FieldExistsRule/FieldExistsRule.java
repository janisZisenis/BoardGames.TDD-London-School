package Lib.Model.InputRules.FieldExistsRule;

import Lib.Data.BoardBoundaries;
import Lib.Data.Input.Input;
import Lib.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.InputRule;

public class FieldExistsRule implements InputRule {

    private final int rowColumnCount = BoardBoundaries.rowColumnCount;

    public boolean isValid(Input input) {
        int row = input.getRow();
        int col = input.getColumn();

        return isOutOfBounds(row) && isOutOfBounds(col);
    }

    private boolean isOutOfBounds(int i) {
        return i >= 0 && i < rowColumnCount;
    }

}
