package App;

import Domain.Board.Board;
import Domain.Data.Mark;
import Domain.IODeviceFactory;
import Domain.InputGeneration.MinimaxInputGenerator.MinimaxInputGenerator;
import Domain.InputGeneration.RandomInputGenerator.RandomInputGenerator;
import InputGeneration.InputGenerator;
import InputGeneration.ValidInputGenerator.InputAlerter;
import Messages.AlertingMessages;
import View.FXInputAlerter;
import View.FXInputView;

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
        return new RandomInputGenerator();
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

    public static void setHumanInputGenerator(FXInputView humanGenerator) {
        FXIODeviceFactory.humanGenerator = humanGenerator;
    }
}
