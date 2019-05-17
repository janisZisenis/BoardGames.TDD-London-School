package BoardGames.View;

import Presentation.ShellPresenter.GameView;
import javafx.scene.layout.Pane;

public abstract class FXGameView extends Pane implements GameView {

    protected double sideLength = getPrefWidth();

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;

        setMinSize(sideLength, sideLength);
        setMaxSize(sideLength, sideLength);
        setPrefSize(sideLength, sideLength);
    }

}
