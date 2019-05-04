package GuiGaming.ValidatingInputProcessor;

import Domain.Data.Field.Field;
import Domain.Input.Input;
import Domain.InputGenerators.AlertingInputGenerator.InputValidator;

public class ValidatingInputProcessor implements InputProcessor {

    private final GuiTurn turn;
    private final InputValidator validator;

    public ValidatingInputProcessor(GuiTurn turn, InputValidator validator) {
        this.turn = turn;
        this.validator = validator;
    }

    public void process(Input input) {
        if(validator.isValid(input)) {
            Field f = makeField(input);
            turn.play(f);
        } else {
            validator.alertIsInvalid(input);
        }
    }

    private Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();
        return new Field(row, col);
    }
}
