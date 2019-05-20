package InteractiveGaming.HybridGameImp;

import Gaming.GameFacade.GameOverRule;
import Input2D.Input.Input;
import InteractiveGaming.HybridGameRunner.HybridGame;

public class HybridGameImp implements HybridGame {

    private final HybridPlayer player;
    private final GameOverRule rule;

    public HybridGameImp(GameOverRule rule, HybridPlayer player) {
        this.rule = rule;
        this.player = player;
    }

    public void playInput(Input input) {
        throwIfIsComputer();
        player.playInput(input);
    }

    private void throwIfIsComputer() {
        if(player.isNotInputTurn())
            throw new HybridGame.CannotPlayHumanOnComputersTurn();
    }

    public boolean nextIsInputTurn() {
        return !player.isNotInputTurn();
    }

    public void runToNextInputTurn() {
        while(player.isNotInputTurn() && !rule.isGameOver())
            player.play();
    }

}
