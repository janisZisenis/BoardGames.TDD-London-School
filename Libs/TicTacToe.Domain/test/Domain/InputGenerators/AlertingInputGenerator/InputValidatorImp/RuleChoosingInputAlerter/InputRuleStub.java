package Domain.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter;

import Domain.Input.Input;
import Domain.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;

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
