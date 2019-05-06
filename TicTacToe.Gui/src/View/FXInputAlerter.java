package View;

import InputGeneration.Input.Input;
import InputGeneration.ValidatingInputGenerator.AlertingInputGenerator.InputAlerter;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class FXInputAlerter implements InputAlerter {

    private final String message;

    public FXInputAlerter(String message) {
        this.message = message;
    }

    public void alert(Input input) {
        Alert a = new Alert(Alert.AlertType.ERROR, message, ButtonType.CLOSE);
        a.showAndWait();
    }

}
