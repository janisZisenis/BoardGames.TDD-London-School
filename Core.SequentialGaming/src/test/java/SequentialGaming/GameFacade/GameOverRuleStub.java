package SequentialGaming.GameFacade;

public class GameOverRuleStub extends GameOverRuleDummy {

    private boolean isGameOver = false;

    public void setIsGameOver(boolean b) {
        this.isGameOver = b;
    }
    public boolean isGameOver() {
        return isGameOver;
    }
}
