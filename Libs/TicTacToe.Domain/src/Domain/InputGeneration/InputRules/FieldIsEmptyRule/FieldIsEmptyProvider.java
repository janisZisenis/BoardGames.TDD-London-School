package Domain.InputGeneration.InputRules.FieldIsEmptyRule;

import Domain.Data.Field.Field;

public interface FieldIsEmptyProvider {
    boolean isEmpty(Field field);
}
