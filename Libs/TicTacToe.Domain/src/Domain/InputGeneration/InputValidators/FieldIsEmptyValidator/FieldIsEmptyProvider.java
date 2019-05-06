package Domain.InputGeneration.InputValidators.FieldIsEmptyValidator;

import Domain.Data.Field.Field;

public interface FieldIsEmptyProvider {
    boolean isEmpty(Field field);
}
