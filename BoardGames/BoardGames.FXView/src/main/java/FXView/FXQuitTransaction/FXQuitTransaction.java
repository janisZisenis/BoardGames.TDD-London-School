package FXView.FXQuitTransaction;

import Utilities.Transaction.Transaction;
import javafx.application.Platform;

public class FXQuitTransaction implements Transaction {

    public void execute() {
        Platform.exit();
        System.exit(0);
    }

}
