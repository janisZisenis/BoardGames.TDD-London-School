package Bussiness.InputRules.FieldIsEmptyRule;

import Api.FieldIsEmptyProvider;
import Data.Field.Field;
import Bussiness.Input.Input;
import Bussiness.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;

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
