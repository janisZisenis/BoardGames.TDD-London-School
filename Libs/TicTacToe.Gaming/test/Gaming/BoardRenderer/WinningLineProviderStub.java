package Gaming.BoardRenderer;

import Data.Line.Line;

public class WinningLineProviderStub implements WinningLineProvider {
    private Line winning = null;

    public void setWinningLine(Line winning) {
        this.winning = winning;
    }

    public boolean hasWinningLine() {
        return winning != null;
    }

    public Line getWinningLine() {
        return winning;
    }
}
