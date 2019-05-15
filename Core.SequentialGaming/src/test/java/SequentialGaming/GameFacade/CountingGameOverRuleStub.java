package SequentialGaming.GameFacade;

public class CountingGameOverRuleStub extends GameOverRuleDummy {

    private int timesNotOver = 0;

    public void setTimesNotOver(int times) {
        this.timesNotOver = times;
    }
    public boolean isGameOver() {
        return timesNotOver-- == 0;
    }

}
