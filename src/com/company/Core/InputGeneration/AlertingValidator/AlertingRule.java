package com.company.Core.InputGeneration.AlertingValidator;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRule;

public class AlertingRule implements InputRule {

    private final InputRule validator;
    private final Alerter alerter;

    public AlertingRule(InputRule validator, Alerter alerter) {
        this.validator = validator;
        this.alerter = alerter;
    }

    public boolean validates(Input input) {
        if(validator.validates(input))
            return true;

        alerter.alert();

        return false;
    }
}
