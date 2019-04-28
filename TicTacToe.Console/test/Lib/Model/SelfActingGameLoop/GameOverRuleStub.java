package Lib.Model.SelfActingGameLoop;

public class GameOverRuleStub implements GameOverRule {
    private boolean isOver;

    public void setGameIsOver(boolean isOver) {
        this.isOver = isOver;
    }

    public boolean isGameOver() {
        return isOver;
    }
}
