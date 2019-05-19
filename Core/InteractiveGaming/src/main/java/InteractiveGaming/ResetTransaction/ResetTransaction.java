package InteractiveGaming.ResetTransaction;

public class ResetTransaction {

    private final ClearBoardService clearBoardService;
    private final ResetPlayerService resetPlayerService;
    private final GameRunner runner;

    public ResetTransaction(ClearBoardService clearBoardService, ResetPlayerService resetPlayerService, GameRunner runner) {
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
