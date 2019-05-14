package View;

import javafx.scene.layout.StackPane;

public class FXTicTacToeView extends StackPane {

    private final FXBoardView board;
    private final FXStartView start;
    private final FXGameOverView gameOver;

    private TicTacToeViewDelegate delegate;

    public FXTicTacToeView(FXBoardView board, FXStartView start, FXGameOverView gameOver) {
        this.board = board;
        this.start = start;
        this.gameOver = gameOver;
        start.setDelegate(this);
        gameOver.setDelegate(this);

        init();
    }

    public void setDelegate(TicTacToeViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void init() {
        setPrefSize(400, 400);

        getChildren().add(board);
        getChildren().add(start);
    }

    public void onStartClicked() {
        int i = 0;
    }

    public void onRestartClicked() {
        int i = 0;
    }
}
