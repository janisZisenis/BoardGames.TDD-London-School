package InteractiveGaming.HybridGameImp;

import Gaming.GameFacade.GameOverRule;
import Input2D.Input.Input;
import InteractiveGaming.HybridExceptions.CanNotPlayWithInput;
import InteractiveGaming.HybridGameRunner.HybridGame;

public class HybridGameImp implements HybridGame {

    private final HybridPlayer player;
    private final GameOverRule rule;

    public HybridGameImp(GameOverRule rule, HybridPlayer player) {
        this.player = player;
        this.rule = rule;
    }

    public boolean nextIsInputTurn() {
        return player.isInputTurn();
    }

    public void playInput(Input input) {
        throwIfNextIsNotInputTurn();

        player.playInput(input);
    }

    private void throwIfNextIsNotInputTurn() {
        if(!player.isInputTurn())
            throw new CanNotPlayWithInput();
    }

    public void runToNextInputTurn() {
        while(isPlayableWithoutInput())
            player.play();
    }

    private boolean isPlayableWithoutInput() {
        return !player.isInputTurn() && !rule.isGameOver();
    }

}
