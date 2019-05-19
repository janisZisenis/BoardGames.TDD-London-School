package Gaming.RestartTransaction;

import Utilities.Transaction.Transaction;

public class RestartTransaction implements Transaction {

    private final ResetGameStateService clearBoardService;
    private final ResetPlayerService resetPlayerService;
    private final GameRunner runner;

    public RestartTransaction(ResetGameStateService clearBoardService, ResetPlayerService resetPlayerService, GameRunner runner) {
        this.clearBoardService = clearBoardService;
        this.resetPlayerService = resetPlayerService;
        this.runner = runner;
    }

    public void execute() {
        clearBoardService.clear();
        resetPlayerService.reset();
        runner.run();
    }
}
