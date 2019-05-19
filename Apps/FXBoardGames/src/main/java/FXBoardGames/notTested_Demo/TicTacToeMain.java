package FXBoardGames.notTested_Demo;

import FXView.Configuration.FXConfigureView;
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
        FXConfigureView configView = new FXConfigureView();

        Transaction loadAction = new LoadGameViewTransaction(configView, viewLoader);
        Transaction runAction = new TicTacToeRunAction(viewLoader, cancelAction, loadAction);

        ConfigureViewPresenter configPresenter = new ConfigureViewPresenter(configView, cancelAction, runAction);
        configView.setDelegate(configPresenter);

        viewLoader.load(configView);
    }

}
