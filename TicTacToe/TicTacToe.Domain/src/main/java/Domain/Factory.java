package Domain;

import Domain.Board.Board;
import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Domain.GameEvaluation.GameEvaluator.Api.WinnerProvider;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.GameEvaluation.GameEvaluator.GameEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineProvider;
import Domain.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Domain.NumberOfMovesRule.NumberOfMovesRule;
import Domain.TicTacToePlayer.TicTacToePlayer;
import Domain.FieldExistsValidator.FieldExistsValidator;
import Domain.FieldIsEmptyValidator.FieldIsEmptyValidator;
import Gaming.GameFacade.GameOverRule;
import Gaming.GameFacade.Player;
import Gaming.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;
import Input2D.InputGenerator;

public abstract class Factory {

    public static Board makeBoard() {
        return new HashingBoard();
    }

    public static ListenableBoard makeListenableBoard() {
        Board board = makeBoard();
        return new ListenableBoard(board);
    }

    public static GameOverRule makeGameOverRule(Board board) {
        LineProvider lineProvider = new HumbleLineProvider();
        LineEvaluator lineEvaluator = new EquallyMarkedLineEvaluator(board);
        GameEvaluator gameEvaluator = new GameEvaluator(lineProvider, lineEvaluator);

        GameOverRule winnerRule = Gaming.Factory.makeWinnerRule(gameEvaluator);
        GameOverRule movesRule = new NumberOfMovesRule(board);

        CompositeGameOverRule composite = Gaming.Factory.makeCompositeGameOverRule();
        composite.add(winnerRule);
        composite.add(movesRule);
        return composite;
    }

    public static WinningLineProvider makeWinningLineProvider(Board board) {
        return makeGameEvaluator(board);
    }

    public static WinnerProvider makeWinnerProvider(Board board) {
        return makeGameEvaluator(board);
    }

    private static GameEvaluator makeGameEvaluator(Board board) {
        LineProvider lineProvider = new HumbleLineProvider();
        LineEvaluator lineEvaluator = new EquallyMarkedLineEvaluator(board);
        return new GameEvaluator(lineProvider, lineEvaluator);
    }

    public static Player makeHumanPlayer(Mark m, Board board, IODeviceFactory factory) {
        InputGenerator generator = factory.makeHumanInputGenerator();
        generator = makeAlertingInputGenerator(generator, board, factory);
        return makeTicTacToePlayer(m, board, generator, factory);
    }

    public static InputGenerator makeAlertingInputGenerator(InputGenerator generator, Board board, IODeviceFactory factory) {
        InputGenerator alerting = Input2D.Factory.makeAlertingInputGenerator(generator,
                new FieldExistsValidator(),
                factory.makeFieldExistsAlerter());
        alerting = Input2D.Factory.makeAlertingInputGenerator(alerting,
                new FieldIsEmptyValidator(board),
                factory.makeFieldIsEmptyAlerter());
        return alerting;
    }

    public static Player makeInvincibleComputerPlayer(Mark m, Board board, IODeviceFactory factory) {
        InputGenerator generator = factory.makeInvincibleInputGenerator(board, m);
        generator = makeValidatingInputGenerator(generator, board, factory);

        return makeTicTacToePlayer(m, board, generator, factory);
    }

    public static Player makeHumbleComputerPlayer(Mark m, Board board, IODeviceFactory factory) {
        InputGenerator generator = factory.makeHumbleInputGenerator();
        generator = makeValidatingInputGenerator(generator, board, factory);

        return makeTicTacToePlayer(m, board, generator, factory);
    }

    private static InputGenerator makeValidatingInputGenerator(InputGenerator generator, Board board, IODeviceFactory factory) {
        InputGenerator validating = Input2D.Factory.makeValidatingInputGenerator(generator,
                new FieldExistsValidator());
        validating = Input2D.Factory.makeValidatingInputGenerator(validating,
                new FieldIsEmptyValidator(board));
        return validating;
    }

    private static Player makeTicTacToePlayer(Mark m, Board board, InputGenerator generator, IODeviceFactory factory) {
        return new TicTacToePlayer(m, board, generator);
    }

}
