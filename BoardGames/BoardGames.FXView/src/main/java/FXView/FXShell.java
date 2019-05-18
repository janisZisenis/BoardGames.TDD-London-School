package FXView;

import Presentation.ShellPresenter.GameView;
import javafx.scene.layout.StackPane;

public class FXShell extends StackPane {

    private final int sideLength = 400;

    public FXShell() {
        setStyle("-fx-background-color: lightgray;");
    }

    public void loadGameView(GameView game) {
        FXGameView g = (FXGameView)game;
        getChildren().clear();
        g.setSideLength(sideLength);
        getChildren().add(g);
    }

}
