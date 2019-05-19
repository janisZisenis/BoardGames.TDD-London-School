package Presentation.Transactions.LoadGameViewTransaction;

public class GameViewLoaderSpy implements GameViewLoader {

    private GameView loadedGameView;

    public GameView getLoadedGameView() {
        return loadedGameView;
    }
    public void load(GameView view) {
        loadedGameView = view;
    }
}
