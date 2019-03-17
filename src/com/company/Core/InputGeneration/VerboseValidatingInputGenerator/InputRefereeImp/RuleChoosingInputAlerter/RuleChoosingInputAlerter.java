package com.company.Core.InputGeneration.VerboseValidatingInputGenerator.InputRefereeImp.RuleChoosingInputAlerter;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.VerboseValidatingInputGenerator.InputRefereeImp.InputAlerter;
import com.company.Core.InputGeneration.InputRule.InputRule;

import java.util.HashMap;

public class RuleChoosingInputAlerter implements InputAlerter {

    private HashMap<InputRule, InputAlerter> pairs = new HashMap<>();

    public void alert(Input input) {
        for(InputRule r : pairs.keySet())
            if(!r.isValid(input)) {
                InputAlerter a = pairs.get(r);
                a.alert(input);
            }
    }

    public void register(InputRule rule, InputAlerter alerter) {
        pairs.put(rule, alerter);
    }
}
