package SequentialGaming.GameFacade;

public class PlayerSpy extends PlayerDummy {

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
