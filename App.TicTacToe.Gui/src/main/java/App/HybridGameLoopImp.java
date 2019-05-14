package App;

import GuiGaming.HybridGameImp.HybridPlayer;
import GuiGaming.HybridGameRunner.HybridGame;
import InputGeneration.Input.Input;
import SequentialGaming.GameFacade.GameOverRule;

public class HybridGameLoopImp implements HybridGame {

    private final GameOverRule rule;
    private final HybridPlayer player;

    public HybridGameLoopImp(GameOverRule rule, HybridPlayer player) {
        this.player = player;
        this.rule = rule;
    }

    public boolean nextIsHuman() {
        return gameNeedsInput();
    }

    public void playHuman(Input input) {
        gamePlay(input);
        playComputerTurns();
    }

    public void playComputerTurns() {
        while(isPlayable())
            play();
    }

    //HybridGame
    private boolean isPlayable() {
        return !rule.isGameOver() && !player.isComputer();
    }

    private void play() {
        player.playComputer();
    }

    private boolean gameNeedsInput() {
        return player.isComputer() && !rule.isGameOver();
    }

    private void gamePlay(Input input) {
        player.playHuman(input);
    }
}
