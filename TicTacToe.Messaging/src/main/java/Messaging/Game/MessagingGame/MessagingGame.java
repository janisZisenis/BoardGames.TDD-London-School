package Messaging.Game.MessagingGame;

import SequentialGaming.GameLoop.Game;

public class MessagingGame {

    private final Game game;
    private final GameMessenger messenger;

    public MessagingGame(Game game, GameMessenger messenger) {
        this.game = game;
        this.messenger = messenger;
    }

    public void play() {
        messenger.publishBeginningMessage();
        game.play();
        messenger.publishEndingMessage();
    }
}
