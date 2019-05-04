package View;

import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class FXMessenger extends Pane {

    private final TextArea text = new TextArea();

    public FXMessenger(int width) {
        setPrefWidth(width);

        text.setEditable(false);
        text.setFocusTraversable(false);

        text.setPrefWidth(width);
        getChildren().addAll(text);
    }

    public void publish(Object message) {
        Platform.runLater(() -> {
            text.appendText(message + "\n");
        });
    }
}
