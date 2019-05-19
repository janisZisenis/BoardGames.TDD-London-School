package Presentation.LoadGameViewTransaction;

import Utilities.Transaction.Transaction;

public class LoadGameViewTransaction implements Transaction {

    private final GameViewLoader loader;
    private final GameView view;

    public LoadGameViewTransaction(GameView view, GameViewLoader loader) {
        this.view = view;
        this.loader = loader;
    }

    public void execute() {
        loader.load(view);
    }
}
