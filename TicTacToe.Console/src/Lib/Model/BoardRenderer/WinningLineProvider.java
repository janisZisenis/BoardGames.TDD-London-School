package Lib.Model.BoardRenderer;
import Lib.Data.Line;

public interface WinningLineProvider {
    boolean hasWinningLine();
    Line getWinningLine();

    class NoWinningLineAvailable extends RuntimeException {}
    class NoWinnerAvailable extends RuntimeException {}
}
