package InteractiveGaming.ResetTransaction;

public class ResetTransaction {

    private final ClearGameStateService clearBoardService;
    private final ResetPlayerService resetPlayerService;
    private final GameRunner runner;

    public ResetTransaction(ClearGameStateService clearBoardService, ResetPlayerService resetPlayerService, GameRunner runner) {
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
