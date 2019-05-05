package InputGeneration.RuleChoosingInputAlerter;

import InputGeneration.Input.Input;
import InputGeneration.InputValidatorImp.InputRule;

public class InputRuleDummy implements InputRule {

    public boolean isValid(Input input) {
        return false;
    }

}
