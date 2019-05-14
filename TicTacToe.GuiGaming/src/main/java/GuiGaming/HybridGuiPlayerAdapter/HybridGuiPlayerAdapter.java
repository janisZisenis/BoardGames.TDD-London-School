package GuiGaming.HybridGuiPlayerAdapter;

import GuiGaming.HybridGameImp.HybridPlayer;
import GuiGaming.MultiGuiPlayer.GuiPlayer;
import InputGeneration.Input.Input;

public class HybridGuiPlayerAdapter implements HybridPlayer {

    private final GuiPlayer player;

    public HybridGuiPlayerAdapter(GuiPlayer player) {
        this.player = player;
    }

    public boolean isComputer() {
        return false;
    }

    public void playComputer() {
        throw new CannotPlayComputerOnHumansTurn();
    }

    public void playHuman(Input input) {
        player.play(input);
    }
}
