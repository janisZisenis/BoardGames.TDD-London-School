package FXView.FXQuitTransaction;

import FXView.FXGameView;

public abstract class FXStackedGameView extends FXGameView {

    protected double sideLength = getPrefWidth();

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;

        setMinSize(sideLength, sideLength);
        setMaxSize(sideLength, sideLength);
        setPrefSize(sideLength, sideLength);
    }

}
