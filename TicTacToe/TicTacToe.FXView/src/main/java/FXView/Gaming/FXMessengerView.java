package FXView.Gaming;

import Messaging.Messenger;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class FXMessengerView extends Pane implements Messenger {

    private final TextArea text = new TextArea();

    public FXMessengerView() {
        text.setEditable(false);
        text.setFocusTraversable(false);

        getChildren().addAll(text);
    }

    public void setFixedWidth(int width) {
        text.setMinWidth(width);
        text.setMaxWidth(width);
    }

    public void publish(String message) {
        text.appendText(message + "\n");
    }
}
