package Utilities.Transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransactionMock implements Transaction {

    private boolean expected = false;
    private boolean actual = false;

    public void expectGetsExecuted() {
        this.expected = true;
    }

    public void execute() {
        actual = true;
    }

    public void verifyAll() {
        assertEquals(expected, actual);
    }
}
