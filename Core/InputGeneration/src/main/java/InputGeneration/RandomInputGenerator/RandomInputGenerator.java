package InputGeneration.RandomInputGenerator;

import InputGeneration.Input.Input;
import InputGeneration.InputGenerator;

import java.util.Random;

public class RandomInputGenerator implements InputGenerator {

    private final int maxRow;
    private final int maxColumn;

    public RandomInputGenerator(int maxRow, int maxColumn) {
        this.maxRow = maxRow;
        this.maxColumn = maxColumn;
    }

    public Input generate() {
        Random random = new Random();

        int row = random.nextInt(maxRow);
        int column = random.nextInt(maxColumn);

        return new Input(row, column);
    }

}
