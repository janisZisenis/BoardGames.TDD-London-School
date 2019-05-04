package Domain.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter;

import Domain.Input.Input;
import Domain.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;

public class InputRuleDummy implements InputRule {

    public boolean isValid(Input input) {
        return false;
    }

}
