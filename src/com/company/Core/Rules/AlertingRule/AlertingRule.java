package com.company.Core.Rules.AlertingRule;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.ValidatingInputGenerator.InputRule;

public class AlertingRule implements InputRule {

    private final InputRule rule;
    private final Alerter alerter;

    public AlertingRule(InputRule rule, Alerter alerter) {
        this.rule = rule;
        this.alerter = alerter;
    }

    public boolean isValid(Input input) {
        if(rule.isValid(input))
            return true;

        alerter.alert();

        return false;
    }
}
