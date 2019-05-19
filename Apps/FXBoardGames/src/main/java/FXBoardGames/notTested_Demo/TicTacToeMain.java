package FXBoardGames.notTested_Demo;

import FXView.Configuration.FXConfigureView;
import Presentation.ConfigureViewPresenter.ConfigureViewPresenter;
import Presentation.ConfigureViewPresenter.RunInteractor;
import Presentation.LoadGameViewTransaction.GameViewLoader;
import Presentation.LoadGameViewTransaction.LoadGameViewTransaction;
import Utilities.Transaction.Transaction;

public class TicTacToeMain implements Transaction {

    private final GameViewLoader viewLoader;
    private final Transaction cancelAction;

    public TicTacToeMain(GameViewLoader viewLoader, Transaction cancelAction) {
        this.viewLoader = viewLoader;
        this.cancelAction = cancelAction;
    }

    public void execute() {
        FXConfigureView configView = new FXConfigureView();

        Transaction configureAction = new LoadGameViewTransaction(configView, viewLoader);
        RunInteractor interactor = new TicTacToeRunInteractor(viewLoader, cancelAction, configureAction);

        ConfigureViewPresenter configPresenter = new ConfigureViewPresenter(configView, cancelAction, interactor);
        configView.setDelegate(configPresenter);

        viewLoader.load(configView);
    }

}
