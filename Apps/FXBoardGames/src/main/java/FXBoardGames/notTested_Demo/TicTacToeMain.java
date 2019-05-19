package FXBoardGames.notTested_Demo;

import FXView.Configuration.FXChoosePlayerView;
import FXView.Configuration.FXConfigureView;
import Presentation.ConfigureViewPresenter.ConfigureViewPresenter;
import Presentation.ConfigureViewPresenter.IsStartableProvider;
import Presentation.Transactions.LoadGameViewTransaction.GameViewLoader;
import Presentation.Transactions.LoadGameViewTransaction.LoadGameViewTransaction;
import Utilities.Transaction.Transaction;

public class TicTacToeMain implements Transaction {

    private final GameViewLoader viewLoader;
    private final Transaction cancelAction;

    public TicTacToeMain(GameViewLoader viewLoader, Transaction cancelAction) {
        this.viewLoader = viewLoader;
        this.cancelAction = cancelAction;
    }

    public void execute() {
        FXChoosePlayerView first = new FXChoosePlayerView();
        FXChoosePlayerView second = new FXChoosePlayerView();
        FXConfigureView configView = new FXConfigureView(first, second);

        Transaction loadAction = new LoadGameViewTransaction(configView, viewLoader);
        Transaction runAction = new TicTacToeRunAction(viewLoader, cancelAction, loadAction);

        IsStartableProvider startableProvider = new IsStartableProvider() {
            public boolean isStartable() {
                return true;
            }
        };

        ConfigureViewPresenter configPresenter = new ConfigureViewPresenter(configView, startableProvider, cancelAction, runAction);
        configView.setDelegate(configPresenter);

        viewLoader.load(configView);
    }

}
