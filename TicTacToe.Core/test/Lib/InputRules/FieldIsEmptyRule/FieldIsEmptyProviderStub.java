package Lib.InputRules.FieldIsEmptyRule;

import Lib.Data.Field.Field;
import java.util.Arrays;

public class FieldIsEmptyProviderStub implements FieldIsEmptyProvider {
    private Field[] empty = {};

    public boolean isEmpty(Field field) {
        return Arrays.asList(empty).contains(field);
    }

    public void setEmptyFields(Field[] empty) {
        this.empty = empty;
    }
}
