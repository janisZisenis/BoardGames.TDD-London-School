package Lib.Model.SelfActingGameLoop;

public class CountingGameOverRuleStub implements GameOverRule {

    private int count = 0;
    private int timesNotGameOver;

    public void setTimesNotGameOver(int times) {
        timesNotGameOver = times;
    }

    public boolean isGameOver() {
        return count++ >= timesNotGameOver;
    }
}

