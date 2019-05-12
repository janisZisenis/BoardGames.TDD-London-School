package App;

import Domain.Board.Board;
import Domain.Data.BoardBoundaries;
import Domain.Data.Mark;
import Domain.IODeviceFactory;
import Domain.InputGeneration.MinimaxInputGenerator.MinimaxInputGenerator;
import InputGeneration.InputGenerator;
import InputGeneration.ValidInputGenerator.InputAlerter;
import Messages.AlertingMessages;
import View.FXInputAlerter;

public class FXIODeviceFactory implements IODeviceFactory {

    public InputGenerator makeHumanInputGenerator() {
        return null;
    }

    public InputGenerator makeInvincibleInputGenerator(Board board, Mark m) {
        return new MinimaxInputGenerator(board, m);
    }

    public InputGenerator makeHumbleInputGenerator() {
        int rowColumnCount = BoardBoundaries.rowColumnCount;
        return InputGeneration.Factory.makeRandomInputGenerator(rowColumnCount, rowColumnCount);
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
