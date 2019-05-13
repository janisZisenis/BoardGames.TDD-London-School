package GuiGaming.HybridGuiPlayerAdapter;

import GuiGaming.MultiGuiPlayer.GuiPlayer;
import GuiGaming.MultiHybridPlayer.HybridPlayer;
import InputGeneration.Input.Input;

public class HybridGuiPlayerAdapter implements HybridPlayer {

    private final GuiPlayer player;

    public HybridGuiPlayerAdapter(GuiPlayer player) {
        this.player = player;
    }

    public boolean needsInput() {
        return true;
    }

    public void play() {
        throw new NeedsInputButWasPlayedWithout();
    }

    public void play(Input input) {
        player.play(input);
    }
}
