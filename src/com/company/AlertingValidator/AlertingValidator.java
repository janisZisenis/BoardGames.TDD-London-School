package com.company.AlertingValidator;

import com.company.UserInput;

public class AlertingValidator implements Validator {

    private final Validator validator;
    private String message;
    private Alerter alerter;

    public AlertingValidator(Validator validator) {
        this.validator = validator;
    }

    public AlertingValidator(Validator validator, Alerter alerter, String message) {
        this(validator);
        this.alerter = alerter;
        this.message = message;
    }

    public boolean isValid(UserInput input) {
        if(validator.isValid(input))
            return true;

        alerter.alert(message);

        return false;
    }
}
