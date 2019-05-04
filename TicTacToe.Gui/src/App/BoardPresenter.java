package App;

import Data.Field.Field;
import Data.Line.Line;
import Gaming.BoardRenderer.BoardView;
import Gaming.BoardRenderer.WinningLineProvider;
import Gaming.GameLoopImp.GameOverRule;
import Gaming.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;
import Gaming.Input.Input;
import GuiGaming.ValidatingInputProcessor.InputProcessor;

public class BoardPresenter implements BoardDelegate {

    private final BoardView view;
    private final InputProcessor processor;
    private GameOverRule rule;
    private WinningLineProvider provider;

    public BoardPresenter(BoardView view, InputProcessor processor, CompositeGameOverRule rule, WinningLineProvider provider) {
        this.processor = processor;
        this.view = view;
        this.rule = rule;
        this.provider = provider;
    }

    public void onInputGenerated(Input input) {
        if(!rule.isGameOver()) {
            processor.process(input);

            onFieldMarked(new Field(input.getRow(), input.getColumn()));
        }
    }

    private void onFieldMarked(Field f) {
        view.showBoard();

        if(rule.isGameOver() && provider.hasWinningLine()) {
            Line line = provider.getWinningLine();
            view.showWinningLine(line);
        }
    }

}
