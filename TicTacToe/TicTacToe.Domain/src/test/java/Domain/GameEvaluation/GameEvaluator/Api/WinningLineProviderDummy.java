package Domain.GameEvaluation.GameEvaluator.Api;

import Domain.Data.Line.Line;

public class WinningLineProviderDummy implements WinningLineProvider {

    public boolean hasWinningLine() {
        return false;
    }

    public Line getWinningLine() {
        return null;
    }

}
