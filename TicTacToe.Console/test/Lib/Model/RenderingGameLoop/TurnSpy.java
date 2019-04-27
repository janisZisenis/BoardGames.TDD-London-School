package Lib.Model.RenderingGameLoop;

import Lib.Model.RenderingGameLoop.GameImp.Turn;

public class TurnSpy implements Turn {
    int timesPlayed = 0;

    public int getPlayedTimes() {
        return timesPlayed;
    }

    public void play() {
        timesPlayed++;
    }

    public boolean hasPlayed() {
        return timesPlayed > 0;
    }
}
