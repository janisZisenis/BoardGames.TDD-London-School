package com.company.Model.GameLoop;

import com.company.Model.GameLoop.GameOverRule;

public class GameOverRuleStub implements GameOverRule {
    private boolean isOver;

    public void setGameIsOver(boolean isOver) {
        this.isOver = isOver;
    }

    public boolean isGameOver() {
        return isOver;
    }
}
