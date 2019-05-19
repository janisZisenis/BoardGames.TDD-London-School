package InteractiveGaming.AsyncProcessingGameRunner;

import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;
import InteractiveGaming.HybridGameRunner.HybridGame;
import InteractiveGaming.HybridGameRunner.HybridGameRunner;
import InteractiveGaming.ResetTransaction.GameRunner;

public class AsyncProcessingGameRunner implements GameRunner, InputProcessor {

    private HybridGameRunner runner;
    private Thread worker;

    public AsyncProcessingGameRunner(HybridGame game) {
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
