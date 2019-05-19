package FXSynchronizingView;

import FXView.Gaming.FXInputAlerter;
import Input2D.Input.Input;
import Input2D.ValidInputGenerator.InputAlerter;
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
