package com.company.Core.InputGeneration.CompositeValidator;

import com.company.Core.Rules.AlertingRule.Alerter;
import com.company.Core.InputGeneration.Input.Input;

import java.util.LinkedList;

public class CompositeValidator {

    private LinkedList<InputRule> rules = new LinkedList<>();

    public boolean isValid(Input input) {

        for (InputRule rule : rules) {
            if (!rule.validates(input))
                return false;
        }

        return true;
    }

    public void register(InputRule rule, Alerter alerter) {
        rules.add(rule);
    }
}
