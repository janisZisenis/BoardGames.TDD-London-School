package Gaming.InputRules.FieldExistsRule;

import Board.BoardBoundaries;
import Gaming.Input.Input;
import Gaming.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;

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
