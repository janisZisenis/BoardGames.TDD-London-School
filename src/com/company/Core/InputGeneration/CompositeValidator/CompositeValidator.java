package com.company.Core.InputGeneration.CompositeValidator;

import com.company.Core.InputGeneration.AlertingValidator.Alerter;
import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRule;

import java.util.LinkedList;

public class CompositeValidator {

    private LinkedList<InputRule> rules = new LinkedList<>();

    public boolean isValid(Input input) {

        for(int i = 0; i < rules.size(); i++) {
            InputRule rule = rules.get(i);
            if(!rule.validates(input))
                return false;
        }

        return true;
    }

    public void register(InputRule rule, Alerter alerter) {
        rules.add(rule);
    }
}
