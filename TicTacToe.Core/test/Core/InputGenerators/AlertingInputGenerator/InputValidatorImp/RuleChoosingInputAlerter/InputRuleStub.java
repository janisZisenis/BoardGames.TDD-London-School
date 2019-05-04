package Core.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter;

import Core.Input.Input;
import Core.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;

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
