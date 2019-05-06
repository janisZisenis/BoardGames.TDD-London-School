package InputGeneration.MappingInputAlerter;

import InputGeneration.Input.Input;
import InputGeneration.InputValidatorImp.InputAlerter;
import InputGeneration.InputValidatorImp.InputValidator;

import java.util.HashMap;

public class MappingInputAlerter implements InputAlerter {

    private HashMap<InputValidator, InputAlerter> pairs = new HashMap<>();

    public void alert(Input input) {
        for(InputValidator v : pairs.keySet())
            alertIfIsInvalid(input, v);
    }

    private void alertIfIsInvalid(Input i, InputValidator v) {
        if(!v.isValid(i))
            pairs.get(v).alert(i);
    }

    public void register(InputValidator validator, InputAlerter alerter) {
        pairs.put(validator, alerter);
    }

}
