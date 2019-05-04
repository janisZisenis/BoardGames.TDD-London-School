package Lib.GameEvaluation.GameEvaluator;

import Lib.BoardRenderer.WinningLineProvider;
import Data.Line.Line;
import Lib.Board.Mark;
import Lib.GameOverRules.WinnerRule.HasWinnerProvider;

public class GameEvaluator implements WinningLineProvider, HasWinnerProvider, WinnerProvider {

    private final LineEvaluator evaluator;
    private final LineProvider provider;

    public GameEvaluator(LineProvider provider, LineEvaluator evaluator) {
        this.provider = provider;
        this.evaluator = evaluator;
    }

    public boolean hasWinner() {
        for(int i = 0; i < provider.getLineCount(); i++)
            if (isWinningLine(i))
                return true;

        return false;
    }

    public Mark getWinner() {
        for(int i = 0; i < provider.getLineCount(); i++)
            if (isWinningLine(i))
                return getWinnerForLine(i);

        throw new NoWinnerAvailable();
    }

    public boolean hasWinningLine() {
        return hasWinner();
    }

    public Line getWinningLine() {
        for(int i = 0; i < provider.getLineCount(); i++)
            if (isWinningLine(i))
                return provider.getLine(i);

        throw new NoWinningLineAvailable();
    }


    private boolean isWinningLine(int index) {
        Line line = provider.getLine(index);
        return evaluator.isWinningLine(line);
    }

    private Mark getWinnerForLine(int index) {
        Line line = provider.getLine(index);
        return evaluator.getWinner(line);
    }
}
