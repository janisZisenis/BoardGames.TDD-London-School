package com.company.Model.InputGenerators.RandomInputGenerator;

import com.company.Data.BoardBoundaries;
import com.company.Data.Input.Input;
import com.company.Model.Players.InputGenerator;

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
