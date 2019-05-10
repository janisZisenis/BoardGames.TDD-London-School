package GuiGaming.TicTacToeFacade;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProvider;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;

public class TicTacToeFacade {

    private final WinningLineProvider winningLineProvider;
    private final MarkedFieldProvider markedFieldProvider;
    private final InputProcessor processor;

    public TicTacToeFacade(MarkedFieldProvider markedFieldProvider, WinningLineProvider winningLineProvider,
                           InputProcessor processor) {
        this.markedFieldProvider = markedFieldProvider;
        this.winningLineProvider = winningLineProvider;
        this.processor = processor;
    }

    public boolean hasWinner() {
        return winningLineProvider.hasWinningLine();
    }

    public Line getWinningLine() {
        return winningLineProvider.getWinningLine();
    }

    public void process(Input input) {
        processor.process(input);
    }

    public boolean isMarked(Field f) {
        return markedFieldProvider.isMarked(f);
    }

    public Mark getMarkAt(Field field) {
        return markedFieldProvider.getMarkAt(field);
    }
}
