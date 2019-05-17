package App;

import Domain.Board.Board;
import Domain.Data.BoardBoundaries;
import Domain.Data.Mark;
import Domain.IODeviceFactory;
import Domain.InputGeneration.MinimaxInputGenerator.MinimaxInputGenerator;
import InputGeneration.InputGenerator;
import InputGeneration.ValidInputGenerator.InputAlerter;
import Messages.AlertingMessages;
import FXView.FXSynchronizingInputAlerter;
import FXView.FXInputView;

public class FXIODeviceFactory implements IODeviceFactory {

    private static FXInputView humanGenerator;

    public InputGenerator makeHumanInputGenerator() {
        if(humanGenerator == null)
            humanGenerator = new FXInputView(200);
        return humanGenerator;
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
        return new FXSynchronizingInputAlerter(inputAlreadyMarked);
    }

    public static void setHumanInputGenerator(FXInputView humanGenerator) {
        FXIODeviceFactory.humanGenerator = humanGenerator;
    }
}
