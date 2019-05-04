package Gaming.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter;

import Gaming.Input.Input;
import Gaming.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;

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
