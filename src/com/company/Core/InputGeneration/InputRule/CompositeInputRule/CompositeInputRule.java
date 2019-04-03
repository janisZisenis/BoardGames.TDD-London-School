package com.company.Core.InputGeneration.InputRule.CompositeInputRule;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRule.InputRule;

import java.util.LinkedList;

public class CompositeInputRule implements InputRule {

    private final LinkedList<InputRule> rules = new LinkedList<InputRule>();

    public boolean isValid(Input input) {
        for (InputRule r : rules)
            if(!r.isValid(input))
                return false;

        return true;
    }

    public void add(InputRule rule) {
        rules.add(rule);
    }

}
