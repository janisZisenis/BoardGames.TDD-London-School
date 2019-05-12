package GuiGaming.TicTacToePresenter;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;
import InputGeneration.Input.Input;

import java.util.HashMap;

public class TicTacToeSpy implements TicTacToe {
    private Input processed;
    private HashMap<Field, Mark> marks = new HashMap<>();
    private Line winningLine = null;
    private boolean didSimulateComputerTurns = false;

    public void setWinningLine(Line line) {
        winningLine = line;
    }
    public boolean hasWinner() {
        return winningLine != null;
    }
    public Line getWinningLine() {
        return winningLine;
    }

    public Input getProcessed() {
        return processed;
    }
    public void process(Input input) {
        processed = input;
    }


    public void addMarkedField(Field field, Mark m) {
        marks.put(field, m);
    }
    public boolean isMarked(Field f) {
        return marks.containsKey(f);
    }
    public Mark getMarkAt(Field field) {
        return marks.get(field);
    }

    public boolean hasSimulatedComputerTurns() {
        return didSimulateComputerTurns;
    }
    public void simulateComputerTurns() {
        didSimulateComputerTurns = true;
    }

}
