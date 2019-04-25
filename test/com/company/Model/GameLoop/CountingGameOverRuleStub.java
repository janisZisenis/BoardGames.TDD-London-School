package com.company.Model.GameLoop;

public class CountingGameOverRuleStub implements GameOverRule {

    int count = 0;
    int timesNotGameOver;

    public void setTimesNotGameOver(int times) {
        timesNotGameOver = times;
    }

    public boolean isGameOver() {
        return count++ >= timesNotGameOver;
    }
}
