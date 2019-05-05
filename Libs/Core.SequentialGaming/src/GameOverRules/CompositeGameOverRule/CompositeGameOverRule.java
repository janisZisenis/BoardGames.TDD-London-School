package GameOverRules.CompositeGameOverRule;

import DelegatingGame.GameOverRule;

import java.util.LinkedList;

public class CompositeGameOverRule implements GameOverRule {

    private LinkedList<GameOverRule> rules = new LinkedList<>();

    public boolean isGameOver() {
        return hasNoRules() || hasTerminatingRule();
    }

    private boolean hasTerminatingRule() {
        for (GameOverRule rule : rules) {
            if(rule.isGameOver())
                return true;
        }
        return false;
    }

    private boolean hasNoRules() {
        return rules.size() == 0;
    }

    public void add(GameOverRule rule) {
        rules.add(rule);
    }
}
