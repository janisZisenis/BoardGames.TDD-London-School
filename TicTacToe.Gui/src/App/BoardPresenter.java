package App;

import Board.Board;
import Data.Field.Field;
import Gaming.BoardRenderer.BoardView;
import Gaming.Input.Input;
import Gaming.InputGenerators.AlertingInputGenerator.InputValidator;
import Gaming.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputValidatorImp;
import Gaming.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter.RuleChoosingInputAlerter;
import Gaming.InputRules.CompositeInputRule.CompositeInputRule;
import Gaming.InputRules.FieldExistsRule.FieldExistsRule;
import Gaming.InputRules.FieldIsEmptyRule.FieldIsEmptyRule;
import Gaming.Messages.AlertingMessages;
import GuiGaming.GuiTurn.GuiTurn;
import View.FXInputAlerter;

public class BoardPresenter implements BoardDelegate {

    private BoardView view;
    private GuiTurn turn;
    private InputValidator validator;

    public BoardPresenter(BoardView view, GuiTurn turn, Board board) {
        this.turn = turn;
        this.view = view;
        initGame(board);
    }

    private void initGame(Board board) {
        CompositeInputRule rule = new CompositeInputRule();
        rule.add(new FieldIsEmptyRule(board));
        rule.add(new FieldExistsRule());
        RuleChoosingInputAlerter alerter = new RuleChoosingInputAlerter();
        alerter.register(new FieldIsEmptyRule(board), new FXInputAlerter(AlertingMessages.inputAlreadyMarked));
        alerter.register(new FieldExistsRule(), new FXInputAlerter(AlertingMessages.inputDoesNotExist));

        validator = new InputValidatorImp(rule, alerter);
    }

    public void onInputGenerated(Input input) {
        if(validator.isValid(input)) {
            process(input);
        } else {
            validator.alertIsInvalid(input);
        }
    }

    private void process(Input input) {
        Field f = makeField(input);
        turn.process(f);

        view.showBoard();
    }

    private Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();
        return new Field(row, col);
    }

}
