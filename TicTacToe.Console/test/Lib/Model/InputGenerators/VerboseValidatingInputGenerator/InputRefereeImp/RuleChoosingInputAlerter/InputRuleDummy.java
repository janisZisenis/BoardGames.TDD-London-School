package Lib.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.RuleChoosingInputAlerter;

import Lib.Data.Input.Input;
import Lib.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.InputRule;

public class InputRuleDummy implements InputRule {

    public boolean isValid(Input input) {
        return false;
    }

}
