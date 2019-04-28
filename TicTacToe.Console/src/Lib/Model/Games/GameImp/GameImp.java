package Lib.Model.Games.GameImp;

import Lib.Model.GameLoopImp.Renderer;
import Lib.Model.Games.MessagingGame.Game;

public class GameImp implements Game {

    private final GameLoop loop;
    private final Renderer renderer;

    public GameImp(Renderer renderer, GameLoop loop) {
        this.renderer = renderer;
        this.loop = loop;
    }

    public void play() {
        renderer.render();
        loop.run();
    }
}
