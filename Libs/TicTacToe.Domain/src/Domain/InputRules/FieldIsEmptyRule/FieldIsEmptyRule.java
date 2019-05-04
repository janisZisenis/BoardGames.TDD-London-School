package Domain.InputRules.FieldIsEmptyRule;

import Data.Field.Field;
import Domain.Board.Api.FieldIsEmptyProvider;
import Domain.Input.Input;
import Domain.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;

public class FieldIsEmptyRule implements InputRule {
    private final FieldIsEmptyProvider provider;

    public FieldIsEmptyRule(FieldIsEmptyProvider provider) {
        this.provider = provider;
    }

    public boolean isValid(Input input) {
        Field f = makeField(input);
        return provider.isEmpty(f);
    }

    private Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();

        return new Field (row, col);
    }
}
