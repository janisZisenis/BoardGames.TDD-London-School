package DelegatingGame;

public class TurnSpy implements Turn {

    private boolean didPlay = false;

    public boolean hasPlayed() {
        return didPlay;
    }
    public void play() {
        didPlay = true;
    }
}
