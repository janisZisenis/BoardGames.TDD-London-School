package Presentation.GameOverView.GameOverViewController;

import Presentation.GameOverView.GameOverViewController.Api.GameOverViewDelegate;
import Utilities.Transaction.Transaction;

public class GameOverViewController implements GameOverViewDelegate {

    private final Transaction cancelAction;
    private final Transaction reconfigureAction;
    private final Transaction restartAction;

    public GameOverViewController(Transaction cancelAction, Transaction reconfigureAction, Transaction restartAction) {
        this.cancelAction = cancelAction;
        this.reconfigureAction = reconfigureAction;
        this.restartAction = restartAction;
    }

    public void onCancelClicked() {
        cancelAction.execute();
    }

    public void onReconfigureClicked() {
        reconfigureAction.execute();
    }

    public void onRestartClicked() {
        restartAction.execute();
    }

}
