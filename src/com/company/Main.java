package com.company;

import com.company.CLI.InputGeneration.BoardPrinter;
import com.company.CLI.InputGeneration.ConsoleAlerter;
import com.company.CLI.InputGeneration.ConsoleInputPrompter;
import com.company.Core.InputGeneration.AlertingValidator.AlertingValidator;
import com.company.Core.InputGeneration.CompositeValidator.CompositeValidator;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.Core.InputGeneration.InputValidator;
import com.company.Core.InputGeneration.PromptingInputGenerator.PromptingInputGenerator;
import com.company.Core.InputGeneration.ValidatingInputGenerator.ValidatingInputGenerator;
import com.company.TicTacToe.HashingBoard.HashingBoard;
import com.company.TicTacToe.Mark;
import com.company.TicTacToe.Constants.AlertingMessages;
import com.company.TicTacToe.CountingReferee.CountingReferee;
import com.company.TicTacToe.Field.Field;
import com.company.TicTacToe.FieldExistsValidator.FieldExistsValidator;
import com.company.TicTacToe.FieldIsEmptyValidator.FieldIsEmptyValidator;
import com.company.TicTacToe.Player.Player;
import com.company.TicTacToe.Player.PlayerConfig;

public class Main {

    private static HashingBoard board = new HashingBoard();
    private static Player current;
    private static Player john;
    private static Player haley;
    private static BoardPrinter printer = new BoardPrinter();

    private static InputGenerator makeTicTacToeInputGenerator(InputValidator validator) {
        ConsoleInputPrompter prompter = new ConsoleInputPrompter();
        InputGenerator generator = new PromptingInputGenerator(prompter);
        return new ValidatingInputGenerator(generator, validator);
    }

    private static CompositeValidator makeTicTacToeValidator(HashingBoard board) {
        InputValidator existsValidator = makeAlertingFieldExistsValidator();
        InputValidator isFreeValidator = makeAlertingFieldIsFreeValidator(board);

        CompositeValidator validator = new CompositeValidator();
        validator.add(existsValidator);
        validator.add(isFreeValidator);
        return validator;
    }

    private static InputValidator makeAlertingFieldIsFreeValidator(HashingBoard board) {
        ConsoleAlerter alreadyMarkedAlerter = new ConsoleAlerter(AlertingMessages.inputAlreadyMarked);
        InputValidator alreadyMarkedValidator = new FieldIsEmptyValidator(board);
        return new AlertingValidator(alreadyMarkedValidator, alreadyMarkedAlerter);
    }

    private static InputValidator makeAlertingFieldExistsValidator() {
        ConsoleAlerter notExistingAlerter = new ConsoleAlerter(AlertingMessages.inputDoesNotExist);
        InputValidator notExistingValidator = new FieldExistsValidator();
        return new AlertingValidator(notExistingValidator, notExistingAlerter);
    }

    private static Player makeHaley(HashingBoard board, InputGenerator generator) {
        PlayerConfig config = new PlayerConfig(generator, board, Mark.Haley);
        return new Player(config);
    }

    private static Player makeJohn(HashingBoard board, InputGenerator generator) {
        PlayerConfig config = new PlayerConfig(generator, board, Mark.John);
        return new Player(config);
    }

    public static void main(String[] args) {
        InputValidator validator = makeTicTacToeValidator(board);
        InputGenerator generator = makeTicTacToeInputGenerator(validator);
        CountingReferee referee = new CountingReferee(board);

        john = makeJohn(board, generator);
        haley = makeHaley(board, generator);
        current = john;

        while(referee.hasMovesLeft()) {
            printer.print(board);
//            if(isWinningRow(0)) break;
//            if(isWinningRow(1)) break;
//            if(isWinningRow(2)) break;
//            if(isWinningColummn(0)) break;
//            if(isWinningColummn(1)) break;
//            if(isWinningColummn(2)) break;
            current.playMove();
            current = current == john ? haley : john;
        }

        printer.print(board);
    }

    private static boolean isWinningColummn(int col) {
        Field first = new Field(0, col);
        Field second = new Field(1, col);
        Field third = new Field(2, col);
        Line line = new Line(first, second, third);

        if (isNotFullyMarked(line))
            return false;

        return isEquallyMarked(line);
    }

    private static boolean isWinningRow(int row) {
        Field first = new Field(row, 0);
        Field second = new Field(row, 1);
        Field third = new Field(row, 2);
        Line line = new Line(first, second, third);

        if (isNotFullyMarked(line))
            return false;

        return isEquallyMarked(line);
    }

    private static boolean isEquallyMarked(Line line) {
        return board.getMarkAt(line.getFirst()) == board.getMarkAt(line.getSecond())
                && board.getMarkAt(line.getFirst()) == board.getMarkAt(line.getThird());
    }

    private static boolean isNotFullyMarked(Line line) {
        return board.isEmpty(line.getFirst())
                || board.isEmpty(line.getSecond())
                || board.isEmpty(line.getThird());
    }

    public static class Line {
        Field first;
        Field second;
        Field third;

        public Line(Field first, Field second, Field third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public Field getFirst() {
            return first;
        }

        public Field getSecond() {
            return second;
        }

        public Field getThird() {
            return third;
        }
    }

}
