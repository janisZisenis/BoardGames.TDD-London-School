package Lib.GameLoopImp;

public class TurnSpy implements Turn {

    private int timesPlayed = 0;

    public void play() {
        timesPlayed++;
    }

    public int getPlayedTimes() {
        return timesPlayed;
    }

}
