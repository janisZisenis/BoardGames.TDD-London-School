package Lib.Model.RenderingGameLoop;

import Lib.Model.RenderingGameLoop.GameImp.GameOverRuleDummy;

public class GameOverRuleStub extends GameOverRuleDummy {
    private boolean isOver;

    public void setGameIsOver(boolean isOver) {
        this.isOver = isOver;
    }

    public boolean isGameOver() {
        return isOver;
    }
}
