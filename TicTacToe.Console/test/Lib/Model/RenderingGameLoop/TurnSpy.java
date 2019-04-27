package Lib.Model.RenderingGameLoop;

import Lib.Model.RenderingGameLoop.GameImp.Turn;

public class TurnSpy implements Turn {

    boolean didPlay = false;

    public void play() {
        didPlay = true;
    }

    public boolean hasPlayed() {
        return didPlay;
    }

}
