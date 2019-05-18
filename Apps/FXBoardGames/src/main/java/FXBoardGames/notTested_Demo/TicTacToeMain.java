package FXBoardGames.notTested_Demo;

import FXView.Configuration.FXChoosePlayerView;
import FXView.Configuration.FXConfigureView;
import Presentation.ChoosePlayerViewPresenter.ChoosePlayerViewPresenter;
import Presentation.ConfigureViewPresenter.ConfigureViewPresenter;
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
        ChoosePlayerViewPresenter firstPresenter = new ChoosePlayerViewPresenter(first);
        first.setDelegate(firstPresenter);

        FXChoosePlayerView second = new FXChoosePlayerView();
        ChoosePlayerViewPresenter secondPresenter = new ChoosePlayerViewPresenter(second);
        second.setDelegate(secondPresenter);

        FXConfigureView configView = new FXConfigureView(first, second);

        Transaction loadAction = new LoadGameViewTransaction(configView, viewLoader);
        Transaction runAction = new TicTacToeRunAction(viewLoader, cancelAction, loadAction);

        PlayersChosenStartableProvider startableProvider = new PlayersChosenStartableProvider(firstPresenter, secondPresenter);
        ConfigureViewPresenter configPresenter = new ConfigureViewPresenter(configView, startableProvider, cancelAction, runAction);
        configView.setDelegate(configPresenter);
        firstPresenter.attach(configPresenter);

        viewLoader.load(configView);
    }

}
