package GuiGaming.TicTacToeFacade;

import Domain.Data.Line.Line;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;

public class WinningLineProviderDummy implements WinningLineProvider {

    public boolean hasWinningLine() {
        return false;
    }

    public Line getWinningLine() {
        return null;
    }

}
