package Input2D.CompositeInputValidator;

import Input2D.Input.Input;
import Input2D.ValidInputGenerator.InputValidator;

import java.util.LinkedList;

public class CompositeInputValidator implements InputValidator {

    private final LinkedList<InputValidator> validators = new LinkedList<>();

    public boolean isValid(Input input) {
        for (InputValidator v : validators)
            if(!v.isValid(input))
                return false;

        return true;
    }

    public void add(InputValidator validator) {
        validators.add(validator);
    }

}
