package Gaming.MessagingGameLoop;

public class MessagingGameLoop implements GameLoop {

    private final GameLoop loop;
    private final GameLoopMessenger messenger;

    public MessagingGameLoop(GameLoop loop, GameLoopMessenger messenger) {
        this.loop = loop;
        this.messenger = messenger;
    }

    public void run() {
        messenger.publishStart();
        loop.run();
        messenger.publishEnd();
    }
}
