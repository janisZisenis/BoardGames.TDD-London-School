package Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter;

import Lib.Data.Input.Input;
import Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputAlerter;
import Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;

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
