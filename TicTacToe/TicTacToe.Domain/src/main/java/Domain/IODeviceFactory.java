package Domain;

import Domain.Board.Board;
import Domain.Data.Mark;
import Input2D.InputGenerator;
import Input2D.ValidInputGenerator.InputAlerter;

public interface IODeviceFactory {
    InputGenerator makeHumanInputGenerator();
    InputGenerator makeInvincibleInputGenerator(Board board, Mark m);
    InputGenerator makeHumbleInputGenerator();

    InputAlerter makeFieldExistsAlerter();
    InputAlerter makeFieldIsEmptyAlerter();
}
