package FXSynchronizingView;

import FXView.Gaming.FXGameOverView;
import Presentation.GameOverViewPresenter.Api.GameOverViewDelegate;
import Presentation.GameOverViewPresenter.GameOverView;
import javafx.application.Platform;
import javafx.scene.layout.StackPane;

public class FXSynchronizingGameOverView extends StackPane implements GameOverView {

    private FXGameOverView view = new FXGameOverView();

    public FXSynchronizingGameOverView() {
        setVisible(false);
        getChildren().add(view);
    }

    public void showGameOverMessage(String message) {
        delay();
        Platform.runLater(() -> {
            this.setVisible(true);
            view.showGameOverMessage(message);
        });
    }

    public void hide() {
        Platform.runLater(() -> {
            this.setVisible(false);
            view.hide();
        });
    }

    private void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setDelegate(GameOverViewDelegate delegate) {
        view.setDelegate(delegate);
    }
}
