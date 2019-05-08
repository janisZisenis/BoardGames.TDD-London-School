package Domain;

import Domain.Board.Board;
import Domain.Data.Mark;
import InputGeneration.InputGenerator;
import InputGeneration.ValidInputGenerator.InputAlerter;
import InputGeneration.ValidInputGenerator.InputValidator;

public class TurnCreationContext {

    private final Mark m;
    private final Board board;
    private final InputGenerator generator;

    private final InputAlerter doesNotExistAlerter;
    private final InputValidator doesNotExistValidator;

    private final InputAlerter alreadyMarkedAlerter;
    private final InputValidator alreadyMarkedValidator;

    public TurnCreationContext(Mark m, Board board,
                               InputGenerator generator,
                               InputAlerter doesNotExistAlerter,
                               InputValidator doesNotExistValidator,
                               InputAlerter alreadyMarkedAlerter,
                               InputValidator alreadyMarkedValidator) {
        this.m = m;
        this.board = board;
        this.generator = generator;

        this.doesNotExistAlerter = doesNotExistAlerter;
        this.doesNotExistValidator = doesNotExistValidator;

        this.alreadyMarkedAlerter = alreadyMarkedAlerter;
        this.alreadyMarkedValidator = alreadyMarkedValidator;
    }

    public Mark getMark() {
        return m;
    }

    public Board getBoard() {
        return board;
    }

    public InputGenerator getInputGenerator() {
        return generator;
    }

    public InputAlerter getDoesNotExistAlerter() {
        return doesNotExistAlerter;
    }

    public InputValidator getDoesNotExistValidator() {
        return doesNotExistValidator;
    }

    public InputAlerter getAlreadyMarkedAlerter() {
        return alreadyMarkedAlerter;
    }

    public InputValidator getAlreadyMarkedValidator() {
        return alreadyMarkedValidator;
    }

}
