package FXSynchronizingView;

import FXView.Gaming.FXMessengerView;
import MappingPlayerMessenger.Messenger;
import javafx.application.Platform;
import javafx.scene.layout.Pane;

public class FXSynchronizingMessengerView extends Pane implements Messenger {

    private final FXMessengerView messenger = new FXMessengerView();

    public FXSynchronizingMessengerView(int width) {
        messenger.setFixedWidth(width);
        getChildren().add(messenger);
    }

    public void publish(String message) {
        Platform.runLater(() -> {
            messenger.publish(message);
        });
    }
}
