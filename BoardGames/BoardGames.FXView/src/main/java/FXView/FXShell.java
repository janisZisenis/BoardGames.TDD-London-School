package FXView;

import Presentation.LoadGameViewTransaction.GameView;
import Presentation.LoadGameViewTransaction.GameViewLoader;
import javafx.scene.layout.StackPane;

public class FXShell extends StackPane implements GameViewLoader {

    private final int sideLength = 400;

    public FXShell() {
        setStyle("-fx-background-color: lightgray;");
    }

    public void load(GameView game) {
        FXGameView g = (FXGameView)game;
        getChildren().clear();
        g.setSideLength(sideLength);
        getChildren().add(g);
    }

}
