package GuiGaming.ValidatingInputProcessor;

import Domain.Data.Field.Field;
import InputGeneration.Input.Input;
import InputGeneration.ValidInputGenerator.InputAlerter;
import InputGeneration.ValidInputGenerator.InputValidator;

public class ValidatingInputProcessor implements InputProcessor {

    private final GuiTurn turn;
    private final InputValidator validator;
    private final InputAlerter alerter;

    public ValidatingInputProcessor(GuiTurn turn, InputValidator validator, InputAlerter alerter) {
        this.turn = turn;
        this.validator = validator;
        this.alerter = alerter;
    }

    public void process(Input input) {
        if(validator.isValid(input)) {
            Field f = makeField(input);
            turn.play(f);
        } else {
            alerter.alert(input);
        }
    }

    private Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();
        return new Field(row, col);
    }
}
