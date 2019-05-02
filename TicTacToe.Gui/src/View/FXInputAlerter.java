package View;

import Lib.Data.Input.Input;
import Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputAlerter;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class FXInputAlerter implements InputAlerter {

    private final String message;

    public FXInputAlerter(String message) {
        this.message = message;
    }

    public void alert(Input input) {
        Platform.runLater(() -> {
            Alert a = new Alert(Alert.AlertType.ERROR, message, ButtonType.CLOSE);
            a.showAndWait();
        });
    }

}
