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
    private final InputProcessor processor;
    private final MarkedFieldProvider markedFieldProvider;

    public TicTacToeFacade(WinningLineProvider winningLineProvider,
                           InputProcessor processor,
                           MarkedFieldProvider markedFieldProvider) {
        this.winningLineProvider = winningLineProvider;
        this.markedFieldProvider = markedFieldProvider;
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
