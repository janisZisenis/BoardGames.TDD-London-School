package Lib.Model.GameLoopImp.GameImp;

public class TurnSpy implements Turn {

    boolean didPlay = false;

    public void play() {
        didPlay = true;
    }

    public boolean hasPlayed() {
        return didPlay;
    }

}
