package Domain.InputGenerators.RandomInputGenerator;

import Domain.Board.BoardBoundaries;
import Domain.Input.Input;
import Domain.Players.InputGenerator;

import java.util.Random;

public class RandomInputGenerator implements InputGenerator {

    int upper = BoardBoundaries.rowColumnCount;

    public Input generate() {
        Random random = new Random();

        int row = random.nextInt(upper);
        int column = random.nextInt(upper);

        return new Input(row, column);
    }

}
