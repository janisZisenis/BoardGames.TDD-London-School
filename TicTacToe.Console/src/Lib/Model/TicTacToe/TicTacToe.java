package Lib.Model.TicTacToe;

import Lib.Model.GameLoopImp.Renderer;

public class TicTacToe {

    private final Receptionist receptionist;
    private final GameLoop loop;
    private final Renderer renderer;

    public TicTacToe(Receptionist receptionist, Renderer renderer, GameLoop loop) {
        this.receptionist = receptionist;
        this.renderer = renderer;
        this.loop = loop;
    }

    public void proceed() {
        receptionist.salute();
        renderer.render();
        loop.run();
        receptionist.takeLeave();
    }
}
