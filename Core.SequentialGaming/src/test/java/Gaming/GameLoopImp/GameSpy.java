package Gaming.GameLoopImp;

public class GameSpy implements Game {

    private int timesNotGameOver = 0;
    private int timesIsOverCalled = 0;

    private int timesPlayed = 0;
    private int timesRendered = 0;

    public void setTimesItsNotOver(int times) {
        this.timesNotGameOver = times;
    }

    public boolean isOver() {
        return  timesIsOverCalled++ >= timesNotGameOver;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void play() {
        timesPlayed++;
    }

    public int getTimesRendered() {
        return timesRendered;
    }

    public void render() {
        timesRendered++;
    }

}
