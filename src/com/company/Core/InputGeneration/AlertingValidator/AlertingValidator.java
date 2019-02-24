package com.company.Core.InputGeneration.AlertingValidator;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputValidator;

public class AlertingValidator implements InputValidator {

    private final InputValidator validator;
    private String message;
    private Alerter alerter;

    public AlertingValidator(InputValidator validator) {
        this.validator = validator;
    }

    public AlertingValidator(InputValidator validator, Alerter alerter, String message) {
        this(validator);
        this.alerter = alerter;
        this.message = message;
    }

    public boolean isValid(Input input) {
        if(validator.isValid(input))
            return true;

        alerter.alert(message);

        return false;
    }
}
