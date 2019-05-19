package FXView;

import javafx.scene.layout.Pane;

public class FXTicTacToeView extends FXGameView {

    private FXGameView boardView;

    public FXTicTacToeView(FXGameView boardView, Pane gameOverView) {
        this.boardView = boardView;

        getChildren().addAll(boardView, gameOverView);
    }

    public void setSideLength(double sideLength) {
        super.setSideLength(sideLength);
        boardView.setSideLength(sideLength);
    }


}
