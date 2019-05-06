package SequentialGaming.DelegatingGame;

public class TurnSpy extends TurnDummy {

    private boolean didPlay = false;
    private int playedTimes = 0;

    public boolean hasPlayed() {
        return didPlay;
    }
    public void play() {
        didPlay = true;
        playedTimes++;
    }

    public int getPlayedTimes() {
        return playedTimes;
    }
}
