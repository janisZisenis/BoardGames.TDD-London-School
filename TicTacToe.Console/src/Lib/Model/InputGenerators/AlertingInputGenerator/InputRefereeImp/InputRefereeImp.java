package Lib.Model.InputGenerators.AlertingInputGenerator.InputRefereeImp;

import Lib.Data.Input.Input;
import Lib.Model.InputGenerators.AlertingInputGenerator.InputReferee;

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
