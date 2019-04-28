package Lib.Model.Game;

import Lib.Model.GameLoopImp.Renderer;

public class Game {

    private final Receptionist receptionist;
    private final GameLoop loop;
    private final Renderer renderer;

    public Game(Receptionist receptionist, Renderer renderer, GameLoop loop) {
        this.receptionist = receptionist;
        this.renderer = renderer;
        this.loop = loop;
    }

    public void play() {
        receptionist.salute();
        renderer.render();
        loop.run();
        receptionist.takeLeave();
    }
}
