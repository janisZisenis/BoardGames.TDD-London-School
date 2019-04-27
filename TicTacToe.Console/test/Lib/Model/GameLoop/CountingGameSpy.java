package Lib.Model.GameLoop;

public class CountingGameSpy implements Game {

    private int timesNotGameOver = 0;

    private int timesPlayed = 0;
    private int timesRendered = 0;
    private String logString = "";

    public int getTimesPlayedTurn() {
        return timesPlayed;
    }
    public void playTurn() {
        timesPlayed++;
        logString += "playTurn ";
    }

    public int getTimesRendered() {
        return timesRendered;
    }
    public void render() {
        timesRendered++;
        logString += "render ";
    }

    public boolean isOver() {
        return timesPlayed >= timesNotGameOver;
    }

    public void setTimesNotGameOver(int timesNotGameOver) {
        this.timesNotGameOver = timesNotGameOver;
    }

    public String getLogString() {
        return logString;
    }
}
