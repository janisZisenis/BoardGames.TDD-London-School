package Core.TwoPlayerTurn;

public class PlayerSpy extends PlayerDummy {
    private int count = 0;

    public void playMove() {
        count++;
    }

    public int getPlayedMoveCount() {
        return count;
    }
}
