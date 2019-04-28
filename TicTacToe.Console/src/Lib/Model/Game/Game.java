package Lib.Model.Game;

import Lib.Model.GameLoopImp.Renderer;

public class Game {

    private final GameLoop loop;
    private final Renderer renderer;

    public Game(Renderer renderer, GameLoop loop) {
        this.renderer = renderer;
        this.loop = loop;
    }

    public void play() {
        renderer.render();
        loop.run();
    }
}
