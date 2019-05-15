package HybridGaming.Presentation.WinningLinePresenter;

import Domain.Data.Line.Line;

public class WinningLineViewSpy implements WinningLineView {

    private boolean didHighlight = false;
    private Line highlighted;

    public boolean hasHighlightedLine() {
        return didHighlight;
    }
    public Line getHighlighted() {
        return highlighted;
    }
    public void highlightLine(Line line) {
        didHighlight = true;
        highlighted = line;
    }

}
