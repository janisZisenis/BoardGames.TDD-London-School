package Domain.InputGeneration.RandomInputGenerator;

import Domain.Data.BoardBoundaries;
import InputGeneration.Input.Input;
import InputGeneration.InputGenerator;

import java.util.Random;

public class RandomInputGenerator implements InputGenerator {

    private int upper = BoardBoundaries.rowColumnCount;

    public Input generate() {
        Random random = new Random();

        int row = random.nextInt(upper);
        int column = random.nextInt(upper);

        return new Input(row, column);
    }

}
