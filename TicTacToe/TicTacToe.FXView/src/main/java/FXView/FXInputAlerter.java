package FXView;

import InputGeneration.Input.Input;
import InputGeneration.ValidInputGenerator.InputAlerter;
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
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
