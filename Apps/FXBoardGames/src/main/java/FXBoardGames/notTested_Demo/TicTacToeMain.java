package FXBoardGames.notTested_Demo;

import Presentation.LoadGameViewTransaction.GameViewLoader;
import Utilities.Transaction.Transaction;

public class TicTacToeMain implements Transaction {

    private final GameViewLoader viewLoader;
    private final Transaction cancelAction;

    public TicTacToeMain(GameViewLoader viewLoader, Transaction cancelAction) {
        this.viewLoader = viewLoader;
        this.cancelAction = cancelAction;
    }

    public void execute() {
//        FXConfigureView configView = new FXConfigureView();
//
//        Transaction configureAction = new LoadGameViewTransaction(configView, viewLoader);
//        RunInteractor interactor = new TicTacToeRunInteractor(viewLoader, cancelAction, configureAction);
//
//        ConfigureViewPresenter configPresenter = new ConfigureViewPresenter(configView, cancelAction, interactor);
//        configView.setDelegate(configPresenter);
//
//        viewLoader.load(configView);
    }

}
