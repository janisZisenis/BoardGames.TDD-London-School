package InteractiveGaming.XHybridGameImp;

import Gaming.GameFacade.GameOverRule;
import Input2D.Input.Input;
import InteractiveGaming.HybridGameRunner.HybridGame;
import InteractiveGaming.XMultiHybridPlayer.XHybridPlayer;

public class XHybridGameImp implements HybridGame {

    private final XHybridPlayer player;
    private final GameOverRule rule;

    public XHybridGameImp(GameOverRule rule, XHybridPlayer player) {
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
            throw new XHybridPlayer.CannotPlayWithInput();
    }

    public void runToNextInputTurn() {
        while(isPlayableWithoutInput())
            player.play();
    }

    private boolean isPlayableWithoutInput() {
        return !player.isInputTurn() && !rule.isGameOver();
    }

}
