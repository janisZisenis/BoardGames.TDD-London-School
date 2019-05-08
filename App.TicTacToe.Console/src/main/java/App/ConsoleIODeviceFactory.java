package App;

import Domain.Board.Board;
import Domain.Data.Mark;
import Domain.IODeviceFactory;
import Domain.InputGeneration.MinimaxInputGenerator.MinimaxInputGenerator;
import Domain.InputGeneration.RandomInputGenerator.RandomInputGenerator;
import InputGeneration.InputGenerator;
import InputGeneration.ValidInputGenerator.InputAlerter;
import Messages.AlertingMessages;
import View.ConsoleInputAlerter;
import View.ConsoleInputGenerator;

public class ConsoleIODeviceFactory implements IODeviceFactory {

    public InputGenerator makeHumanInputGenerator() {
        return new ConsoleInputGenerator();
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

    private InputAlerter makeInputAlerter(String inputDoesNotExist) {
        return new ConsoleInputAlerter(inputDoesNotExist);
    }
}
