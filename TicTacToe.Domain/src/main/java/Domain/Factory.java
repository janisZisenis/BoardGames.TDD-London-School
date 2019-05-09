package Domain;

import Domain.Board.Board;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.Board.ListenableBoard.ListenableBoard;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Domain.GameEvaluation.GameEvaluator.Api.WinnerProvider;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.GameEvaluation.GameEvaluator.GameEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineProvider;
import Domain.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Domain.InputFieldGeneratorAdapter.InputFieldGeneratorAdapter;
import Domain.InputGeneration.InputValidators.FieldExistsValidator.FieldExistsValidator;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import Domain.NumberOfMovesRule.NumberOfMovesRule;
import Domain.TicTacToePlayer.TicTacToePlayer;
import InputGeneration.InputGenerator;
import SequentialGaming.DelegatingGame.GameOverRule;
import SequentialGaming.DelegatingGame.Player;
import SequentialGaming.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;

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

        GameOverRule winnerRule = SequentialGaming.Factory.makeWinnerRule(gameEvaluator);
        GameOverRule movesRule = new NumberOfMovesRule(board);

        CompositeGameOverRule composite = SequentialGaming.Factory.makeCompositeGameOverRule();
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
        return makeTicTacToePlayer(m, board, generator, factory);
    }

    public static Player makeInvincableComputerPlayer(Mark m, Board board, IODeviceFactory factory) {
        InputGenerator generator = factory.makeInvincibleInputGenerator(board, m);
        return makeTicTacToePlayer(m, board, generator, factory);
    }

    public static Player makeHumbleComputerPlayer(Mark m, Board board, IODeviceFactory factory) {
        InputGenerator generator = factory.makeHumbleInputGenerator();
        return makeTicTacToePlayer(m, board, generator, factory);
    }

    private static Player makeTicTacToePlayer(Mark m, Board board, InputGenerator generator, IODeviceFactory factory) {
        generator = InputGeneration.Factory.makeAlertingInputGenerator(generator,
                new FieldExistsValidator(),
                factory.makeFieldExistsAlerter());
        generator = InputGeneration.Factory.makeAlertingInputGenerator(generator,
                new FieldIsEmptyValidator(board),
                factory.makeFieldIsEmptyAlerter());

        InputFieldGeneratorAdapter generatorAdapter = new InputFieldGeneratorAdapter(generator);
        return new TicTacToePlayer(m, board, generatorAdapter);
    }

}
