package GuiGaming.HybridGameImp;

import SequentialGaming.GameFacade.GameOverRule;

public class CountingGameOverRuleStub implements GameOverRule {

    private int timesNotOver = 0;

    public void setTimesNotOver(int times) {
        this.timesNotOver = times;
    }
    public boolean isGameOver() {
        return timesNotOver-- == 0;
    }

}
