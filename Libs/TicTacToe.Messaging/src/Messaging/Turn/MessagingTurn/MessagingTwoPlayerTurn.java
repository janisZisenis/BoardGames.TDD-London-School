package Messaging.Turn.MessagingTurn;

import Gaming.TwoPlayerTurn.Player;
import Gaming.TwoPlayerTurn.TwoPlayerTurn;

public class MessagingTwoPlayerTurn extends TwoPlayerTurn {
    private TurnMessenger view;

    public MessagingTwoPlayerTurn(Player first, Player second, TurnMessenger view) {
        super(first, second);
        this.view = view;
    }

    public void play() {
        view.publishTurnMessageFor(current);
        super.play();
    }

}
