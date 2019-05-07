package Domain;

import Domain.Board.Board;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Domain.GameEvaluation.GameEvaluator.Api.WinnerProvider;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.GameEvaluation.GameEvaluator.GameEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineProvider;
import Domain.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Domain.InputFieldGeneratorAdapter.InputFieldGeneratorAdapter;
import Domain.NumberOfMovesRule.NumberOfMovesRule;
import Domain.Turn.TicTacToeTurn;
import InputGeneration.InputGenerator;
import SequentialGaming.DelegatingGame.GameOverRule;
import SequentialGaming.DelegatingGame.Turn;
import SequentialGaming.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;

public abstract class Factory {

    public static Board makeBoard() {
        return new HashingBoard();
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

    public static Turn makeTicTacToeTurn(TurnCreationContext cxt) {
        InputGenerator generator = cxt.getInputGenerator();
        generator = InputGeneration.Factory.makeAlertingInputGenerator(generator,
                                                                       cxt.getDoesNotExistValidator(),
                                                                       cxt.getDoesNotExistAlerter());
        generator = InputGeneration.Factory.makeAlertingInputGenerator(generator,
                                                                       cxt.getAlreadyMarkedValidator(),
                                                                       cxt.getAlreadyMarkedAlerter());
        InputFieldGeneratorAdapter generatorAdapter = new InputFieldGeneratorAdapter(generator);

        return new TicTacToeTurn(cxt.getMark(), cxt.getBoard(), generatorAdapter);
    }

}
