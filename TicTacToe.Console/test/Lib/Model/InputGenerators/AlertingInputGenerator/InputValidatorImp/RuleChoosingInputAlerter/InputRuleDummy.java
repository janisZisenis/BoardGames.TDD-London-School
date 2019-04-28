package Lib.Model.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter;

import Lib.Data.Input.Input;
import Lib.Model.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;

public class InputRuleDummy implements InputRule {

    public boolean isValid(Input input) {
        return false;
    }

}
