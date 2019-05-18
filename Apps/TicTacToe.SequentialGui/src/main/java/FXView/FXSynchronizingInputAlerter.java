package FXView;

import FXView.Gaming.FXInputAlerter;
import InputGeneration.Input.Input;
import InputGeneration.ValidInputGenerator.InputAlerter;
import javafx.application.Platform;

public class FXSynchronizingInputAlerter implements InputAlerter {

    private final FXInputAlerter alerter;

    public FXSynchronizingInputAlerter(String message) {
        alerter = new FXInputAlerter(message);
    }

    public void alert(Input input) {
        sleep(50);

        Platform.runLater(() -> {
            alerter.alert(input);
        });
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
