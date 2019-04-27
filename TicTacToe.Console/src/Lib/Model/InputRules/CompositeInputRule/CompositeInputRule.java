package Lib.Model.InputRules.CompositeInputRule;

import Lib.Data.Input.Input;
import Lib.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.InputRule;

import java.util.LinkedList;

public class CompositeInputRule implements InputRule {

    private final LinkedList<InputRule> rules = new LinkedList<InputRule>();

    public boolean isValid(Input input) {
        for (InputRule r : rules)
            if(!r.isValid(input))
                return false;

        return true;
    }

    public void add(InputRule rule) {
        rules.add(rule);
    }

}
