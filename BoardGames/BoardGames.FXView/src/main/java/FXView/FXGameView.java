package FXView;

import Presentation.ShellPresenter.GameView;
import javafx.scene.layout.StackPane;

public abstract class FXGameView extends StackPane implements GameView {

    protected double sideLength = getPrefWidth();

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;

        setMinSize(sideLength, sideLength);
        setMaxSize(sideLength, sideLength);
        setPrefSize(sideLength, sideLength);
    }

}
