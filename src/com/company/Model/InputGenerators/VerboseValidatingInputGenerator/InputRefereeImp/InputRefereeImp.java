package com.company.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp;

import com.company.Data.Input.Input;
import com.company.Model.InputGenerators.VerboseValidatingInputGenerator.InputReferee;

public class InputRefereeImp implements InputReferee {

    private InputRule rule;
    private final InputAlerter alerter;

    public InputRefereeImp(InputRule rule, InputAlerter alerter) {
        this.rule = rule;
        this.alerter = alerter;
    }

    public boolean isValid(Input input) {
        return rule.isValid(input);
    }

    public void alertIsInvalid(Input input) {
        alerter.alert(input);
    }
}
