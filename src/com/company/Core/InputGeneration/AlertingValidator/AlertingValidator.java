package com.company.Core.InputGeneration.AlertingValidator;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputValidator;

public class AlertingValidator implements InputValidator {

    private final InputValidator validator;
    private final Alerter alerter;

    public AlertingValidator(InputValidator validator, Alerter alerter) {
        this.validator = validator;
        this.alerter = alerter;
    }

    public boolean isValid(Input input) {
        if(validator.isValid(input))
            return true;

        alerter.alert();

        return false;
    }
}
