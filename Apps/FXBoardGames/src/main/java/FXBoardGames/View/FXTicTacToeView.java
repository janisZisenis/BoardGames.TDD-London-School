package FXBoardGames.View;

import View.FXGameView;
import javafx.scene.layout.StackPane;

public class FXTicTacToeView extends FXGameView {


    private final FXTicTacToeConfigView configView = new FXTicTacToeConfigView();
    private final FXBoardView boardView = new FXBoardView(3);

    private StackPane stack = new StackPane();

    public FXTicTacToeView() {
        stack.getChildren().add(boardView);
        stack.getChildren().add(configView);
        getChildren().add(stack);
    }

    public void setSideLength(double sideLength) {
        super.setSideLength(sideLength);
        boardView.setSideLength(sideLength);
    }

}
