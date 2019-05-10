package Domain.TicTacToePlayer;

import Domain.Data.Field.Field;

public class FieldGeneratorStub implements FieldGenerator {

    private Field generatedField;

    public void setGeneratedField(Field field) {
        this.generatedField = field;
    }
    public Field generate() {
        return generatedField;
    }
}
