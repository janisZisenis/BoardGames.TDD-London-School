package FXBoardGames.notTested_Demo;

import Input2D.Input.Input;
import Input2D.InputProcessor;
import InteractiveGaming.HybridGameRunner.HybridGame;
import InteractiveGaming.HybridGameRunner.HybridGameRunner;
import InteractiveGaming.ResetTransaction.GameRunner;

public class AsyncHybridGameRunner implements GameRunner, InputProcessor {

    private HybridGameRunner runner;
    private Thread worker;

    public AsyncHybridGameRunner(HybridGame game) {
        this.runner = new HybridGameRunner(game);
    }

    public void process(Input input) {
        worker = new Thread() {
            public void run() {
                runner.process(input);
            }
        };

        worker.start();
    }

    public void run() {
        worker = new Thread() {
            public void run() {
                runner.run();
            }
        };

        worker.start();
    }
}
