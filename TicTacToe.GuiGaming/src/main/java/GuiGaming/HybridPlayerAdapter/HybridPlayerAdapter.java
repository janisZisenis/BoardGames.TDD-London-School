package GuiGaming.HybridPlayerAdapter;

import GuiGaming.MultiHybridPlayer.HybridPlayer;
import InputGeneration.Input.Input;
import SequentialGaming.GameFacade.Player;

public class HybridPlayerAdapter implements HybridPlayer {

    private final Player player;

    public HybridPlayerAdapter(Player player) {
        this.player = player;
    }

    public boolean needsInput() {
        return false;
    }

    public void play(Input input) {
        throw new DoesNotNeedInputButWasPlayedWith();
    }

    public void play() {
        player.play();
    }
}
