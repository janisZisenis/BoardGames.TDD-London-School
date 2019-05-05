package DelegatingGame;

public class GameOverRuleStub implements GameOverRule {

    private boolean isGameOver = false;

    public void setIsGameOver(boolean b) {
        this.isGameOver = b;
    }
    public boolean isGameOver() {
        return isGameOver;
    }
}
