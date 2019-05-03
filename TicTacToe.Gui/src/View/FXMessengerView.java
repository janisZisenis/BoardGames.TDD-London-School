package View;

import Lib.Data.Field.Field;
import Lib.GameOverMessageProviderImp.GameOverMessageProvider;
import Lib.Games.MessagingGame.GameMessenger;
import Lib.ObjectToStringMapper.ObjectToMessageMapper;
import Lib.Players.MessagingPlayer.PlayerMessenger;
import Lib.TwoPlayerTurn.MessagingTwoPlayerTurn.TurnMessenger;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class FXMessengerView extends Pane implements GameMessenger, TurnMessenger, PlayerMessenger {

    private final String beginningMessage = "Welcome to TicTacToe!";

    private final TextArea text = new TextArea();
    private final GameOverMessageProvider provider;
    private final ObjectToMessageMapper mapper;

    public FXMessengerView(int width, GameOverMessageProvider provider, ObjectToMessageMapper mapper) {
        this.provider = provider;
        this.mapper = mapper;

        setPrefWidth(width);
        text.setEditable(false);
        text.setFocusTraversable(false);

        text.setPrefWidth(width);
        getChildren().addAll(text);
    }


    public void publishBeginningMessage() {
        text.appendText(beginningMessage + "\n");
    }

    public void publishGameOverMessage() {
        String message = provider.getGameOverMessage();
        append(message);
    }

    public void publishTurnMessageFor(Object player) {
        String message = mapper.map(player);
        append(message + "\n");
    }

    public void publishPlayedMove(Field f) {
        String message = getMessage(f);
        Platform.runLater(() ->{
            text.appendText(message);
        });
    }

    private String getMessage(Field f) {
        int row = f.getRow();
        int col = f.getColumn();

        return "Field [" + row + ", " + col + "] was marked!\n";
    }

    public void append(String s) {
        Platform.runLater(() ->{
            text.appendText(s);
        });
    }

}

