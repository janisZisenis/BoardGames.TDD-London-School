package Lib.Model.InputGenerators.RandomInputGenerator;

import Lib.Data.BoardBoundaries;
import Lib.Data.Input.Input;
import Lib.Model.Players.InputGenerator;

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
