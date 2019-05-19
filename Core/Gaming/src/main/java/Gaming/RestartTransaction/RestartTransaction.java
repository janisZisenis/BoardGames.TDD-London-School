package Gaming.RestartTransaction;

import Gaming.GameLoopImp.Api.GameLoop;
import Utilities.Transaction.Transaction;

public class RestartTransaction implements Transaction {

    private final ClearGameStateService ClearGameStateService;
    private final ResetPlayerService resetPlayerService;
    private final GameLoop runner;

    public RestartTransaction(ClearGameStateService ClearGameStateService, ResetPlayerService resetPlayerService, GameLoop runner) {
        this.ClearGameStateService = ClearGameStateService;
        this.resetPlayerService = resetPlayerService;
        this.runner = runner;
    }

    public void execute() {
        ClearGameStateService.clear();
        resetPlayerService.reset();
        runner.run();
    }
}
