package FXBoardGames.notTested_Demo;

import Presentation.Transactions.LoadGameViewTransaction.GameViewLoader;
import Utilities.Transaction.Transaction;

public class TicTacToeRunArgs {

    private GameViewLoader viewLoader;
    private Transaction cancelAction;
    private Transaction configureAction;

    public GameViewLoader getViewLoader() {
        return viewLoader;
    }

    public void setViewLoader(GameViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    public Transaction getCancelAction() {
        return cancelAction;
    }

    public void setCancelAction(Transaction cancelAction) {
        this.cancelAction = cancelAction;
    }

    public Transaction getConfigureAction() {
        return configureAction;
    }

    public void setConfigureAction(Transaction configureAction) {
        this.configureAction = configureAction;
    }

}
