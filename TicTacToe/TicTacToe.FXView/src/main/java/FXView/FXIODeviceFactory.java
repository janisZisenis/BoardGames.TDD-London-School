package FXView;

import Domain.Board.Board;
import Domain.Data.BoardBoundaries;
import Domain.Data.Mark;
import Domain.IODeviceFactory;
import Domain.MinimaxInputGenerator.MinimaxInputGenerator;
import FXView.Gaming.FXInputAlerter;
import Input2D.InputGenerator;
import Input2D.ValidInputGenerator.InputAlerter;
import Messages.AlertingMessages;

public class FXIODeviceFactory implements IODeviceFactory {

    public InputGenerator makeHumanInputGenerator() {
        return null;
    }

    public InputGenerator makeInvincibleInputGenerator(Board board, Mark m) {
        return new MinimaxInputGenerator(board, m);
    }

    public InputGenerator makeHumbleInputGenerator() {
        int rowColumnCount = BoardBoundaries.rowColumnCount;
        return Input2D.Factory.makeRandomInputGenerator(rowColumnCount, rowColumnCount);
    }

    public InputAlerter makeFieldExistsAlerter() {
        return makeInputAlerter(AlertingMessages.inputDoesNotExist);
    }

    public InputAlerter makeFieldIsEmptyAlerter() {
        return makeInputAlerter(AlertingMessages.inputAlreadyMarked);
    }

    private InputAlerter makeInputAlerter(String inputAlreadyMarked) {
        return new FXInputAlerter(inputAlreadyMarked);
    }

}
