package Domain.InputRules.FieldExistsRule;

import Domain.Board.BoardBoundaries;
import Domain.Input.Input;
import Domain.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;

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
