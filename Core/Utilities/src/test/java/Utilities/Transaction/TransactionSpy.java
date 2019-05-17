package Utilities.Transaction;

public class TransactionSpy implements Transaction {

    private boolean didExecute = false;

    public boolean hasExecuted() {
        return didExecute;
    }
    public void execute() {
        didExecute = true;
    }
}
