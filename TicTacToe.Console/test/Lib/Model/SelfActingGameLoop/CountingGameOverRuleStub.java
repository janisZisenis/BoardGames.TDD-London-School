package Lib.Model.SelfActingGameLoop;

import Lib.Model.GameLoopImp.GameImp.GameOverRule;

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

