package Core.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter;

import Core.Input.Input;
import Core.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;

public class InputRuleDummy implements InputRule {

    public boolean isValid(Input input) {
        return false;
    }

}
