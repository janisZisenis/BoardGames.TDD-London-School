package Domain.RuleChoosingInputAlerter;

import Domain.Input.Input;
import Domain.InputValidatorImp.InputRule;

public class InputRuleDummy implements InputRule {

    public boolean isValid(Input input) {
        return false;
    }

}
