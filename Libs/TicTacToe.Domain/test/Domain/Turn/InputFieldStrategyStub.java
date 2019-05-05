package Domain.Turn;

import Domain.Data.Field.Field;

public class InputFieldStrategyStub implements InputFieldStrategy {

    private Field generatedField;

    public void setGeneratedField(Field field) {
        this.generatedField = field;
    }
    public Field generateField() {
        return generatedField;
    }
}
