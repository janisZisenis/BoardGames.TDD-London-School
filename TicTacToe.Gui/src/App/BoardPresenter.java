package App;

import Board.Board;
import Gaming.BoardRenderer.BoardView;
import Gaming.Input.Input;
import GuiGaming.ValidatingInputProcessor.InputProcessor;

public class BoardPresenter implements BoardDelegate {

    private BoardView view;
    private final InputProcessor processor;

    public BoardPresenter(BoardView view, InputProcessor processor, Board board) {
        this.processor = processor;
        this.view = view;
        initGame(board);
    }

    private void initGame(Board board) {
    }

    public void onInputGenerated(Input input) {
        processor.process(input);
        view.showBoard();
    }

}
