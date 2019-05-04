package Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter;

import Lib.Input.Input;
import Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;

import java.util.Arrays;

public class InputRuleStub implements InputRule {
    private Input[] valid = {};

    public boolean isValid(Input input) {
        return Arrays.asList(valid).contains(input);
    }

    public void setValidInputs(Input[] valid) {
        this.valid = valid;
    }
}
