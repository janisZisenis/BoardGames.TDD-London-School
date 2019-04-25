package com.company.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.RuleChoosingInputAlerter;

import com.company.Data.Input.Input;
import com.company.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.InputRule;

public class InputRuleDummy implements InputRule {

    public boolean isValid(Input input) {
        return false;
    }

}
