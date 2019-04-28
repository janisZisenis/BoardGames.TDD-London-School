package Lib.Model.GameLoopImp;

public class TurnSpy implements Turn {

    private boolean didPlay = false;
    private int timesPlayed = 0;

    public void play() {
        didPlay = true;
        timesPlayed++;
    }

    public boolean hasPlayed() {
        return didPlay;
    }

    public int getPlayedTimes() {
        return timesPlayed;
    }

}
