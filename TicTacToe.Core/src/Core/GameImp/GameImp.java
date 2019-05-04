package Core.GameImp;

import Core.GameLoopImp.Renderer;

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
