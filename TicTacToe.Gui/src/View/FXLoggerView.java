package View;

import Lib.Data.Mark;
import Lib.GameEvaluation.WinnerProvider;
import Lib.Games.MessagingGame.GameMessenger;
import Lib.MarkToStringMapper.MarkToStringMapper;
import Lib.TwoPlayerTurn.MessagingTwoPlayerTurn.TurnMessenger;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.util.HashMap;

public class FXLoggerView extends Pane implements GameMessenger, TurnMessenger {

    private final HashMap<Object, String> names = new HashMap<Object, String>();

    private final String beginningMessage = "Welcome to TicTacToe!";
    private final String winnerMessage = " wins!";
    private final String drawMessage = "Draw!";
    private final String turnMessageEnding = ", it's your turn!";

    private final WinnerProvider provider;
    private final MarkToStringMapper mapper;

    TextArea text = new TextArea();

    public FXLoggerView(int width, WinnerProvider provider, MarkToStringMapper mapper) {
        this.provider = provider;
        this.mapper = mapper;

        setPrefWidth(width);
        text.setDisable(true);

        text.setPrefWidth(width);
        getChildren().addAll(text);
    }


    public void publishBeginningMessage() {
        text.appendText(beginningMessage + "\n");
    }

    public void publishGameOverMessage() {
        String message;
        if(provider.hasWinner()) {
            Mark winner = provider.getWinner();
            String s = mapper.map(winner);
            message = s + winnerMessage + "\n";
        } else {
            message = drawMessage + "\n";
        }
        append(message);
    }

    public void publishTurnMessageFor(Object player) {
        String name = names.get(player);
        append(name + turnMessageEnding + "\n");
    }

    public void register(Object player, String name) {
        names.put(player, name);
    }

    public void append(String s) {
        Platform.runLater(() ->{
            text.appendText(s);
        });
    }

}
