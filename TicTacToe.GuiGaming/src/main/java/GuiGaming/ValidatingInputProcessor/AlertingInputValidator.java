package GuiGaming.ValidatingInputProcessor;

import InputGeneration.Input.Input;

public interface AlertingInputValidator {
    boolean isValid(Input input);
    void alertIsInvalid(Input input);
}
