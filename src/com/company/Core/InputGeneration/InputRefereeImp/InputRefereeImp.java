package com.company.Core.InputGeneration.InputRefereeImp;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputAlerter.InputAlerter;
import com.company.Core.InputGeneration.InputRule.InputRule;
import com.company.Core.InputGeneration.VerboseValidatingInputGenerator.InputReferee;

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
