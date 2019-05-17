package FXBoardGames.View;

import FXView.FXGameView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class FXTicTacToeView extends FXGameView {


    private final Pane configView;
    private final FXGameView boardView;

    private StackPane stack = new StackPane();

    public FXTicTacToeView(Pane configView, FXGameView boardView) {
        this.configView = configView;
        this.boardView = boardView;
        stack.getChildren().add(boardView);
        stack.getChildren().add(configView);
        getChildren().add(stack);
    }

    public void setSideLength(double sideLength) {
        super.setSideLength(sideLength);
        boardView.setSideLength(sideLength);
    }

}
