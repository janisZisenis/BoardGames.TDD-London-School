package Domain.InputGenerators.MinimaxInputGenerator;

import Domain.Data.BoardBoundaries;
import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProvider;
import Domain.Input.Input;
import Domain.Players.InputGenerator;

public class MinimaxInputGenerator implements InputGenerator {

    private final MarkedFieldProvider provider;
    private final Mark me;
    private final Mark opponent;

    private Mark[][] board;

    public MinimaxInputGenerator(MarkedFieldProvider provider, Mark me){
        this.provider = provider;
        this.me = me;
        this.opponent = me == Mark.John ? Mark.Haley : Mark.John;
    }

    public Input generate() {
        copyBoard();

        int currentScore = -2;
        int bestScore = -2;
        int bestRow = -1;
        int bestColumn = -1;

        for(int i = 0; i < BoardBoundaries.rowColumnCount; i++) {
            for(int j = 0; j < BoardBoundaries.rowColumnCount; j++) {
                if(board[i][j] == null) {
                    board[i][j] = me;
                    currentScore = minimaxForO();

                    if(currentScore > bestScore) {
                        bestScore = currentScore;
                        bestRow = i;
                        bestColumn = j;
                    }
                    board[i][j] = null;
                }
            }
        }

        return new Input(bestRow, bestColumn);
    }

    private int minimaxForO() {
        if(gameOver()) {
            return score();
        }

        int currentScore = 2;
        int bestScore = 2;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(board[i][j] == null) {
                    board[i][j] = opponent;
                    currentScore = minimaxForX();

                    if(currentScore < bestScore) {
                        bestScore = currentScore;
                    }
                    board[i][j] = null;
                }
            }
        }

        return bestScore;
    }

    private int minimaxForX() {
        if(gameOver()) {
            return score();
        }

        int currentScore = -2;
        int bestScore = -2;

        for(int i = 0; i < BoardBoundaries.rowColumnCount; i++) {
            for(int j = 0; j < BoardBoundaries.rowColumnCount; j++) {
                if(board[i][j] == null) {
                    board[i][j] = me;
                    currentScore = minimaxForO();

                    if(currentScore > bestScore) {
                        bestScore = currentScore;
                    }
                    board[i][j] = null;
                }
            }
        }

        return bestScore;
    }

    private int score() {
        int localScore;

        for(int i = 0; i < BoardBoundaries.rowColumnCount; i++) {
            localScore = scoreLine(board[i][0], board[i][1], board[i][2]);
            if(localScore != 0)
                return localScore;

            localScore = scoreLine(board[0][i], board[1][i], board[2][i]);
            if(localScore != 0)
                return localScore;
        }

        localScore = scoreLine(board[0][0], board[1][1], board[2][2]);
        if(localScore != 0)
            return localScore;

        return scoreLine(board[0][2], board[1][1], board[2][0]);
    }

    private int scoreLine(Mark first, Mark second, Mark third) {
        if(first == second && second == third) {
            if(first == me) return 1;
            if(second == opponent) return -1;
        }

        return 0;
    }

    private boolean gameOver() {
        return hasWinner() || hasNoFreeFieldsLeft();
    }

    private boolean hasNoFreeFieldsLeft() {
        for(int i = 0; i < BoardBoundaries.rowColumnCount; i++)
            for(int j = 0; j < BoardBoundaries.rowColumnCount; j++)
                if(board[i][j] == null)
                    return false;

        return true;
    }

    private boolean hasWinner() {
        return score() != 0;
    }

    private void copyBoard() {
        board = new Mark[BoardBoundaries.rowColumnCount][BoardBoundaries.rowColumnCount];
        for(int row = 0; row < BoardBoundaries.rowColumnCount; row++)
            copyRow(row);
    }

    private void copyRow(int row) {
        for(int col = 0; col < BoardBoundaries.rowColumnCount; col++)
            copyField(row, col);
    }

    private void copyField(int row, int col) {
        Field f = new Field(row, col);
        if(provider.isMarked(f)) {
            board[row][col] = provider.getMarkAt(f);
        }
    }


}
