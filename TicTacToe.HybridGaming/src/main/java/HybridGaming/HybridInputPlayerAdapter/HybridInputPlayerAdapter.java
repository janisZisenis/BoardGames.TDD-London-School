package HybridGaming.HybridInputPlayerAdapter;

import HybridGaming.HybridGameImp.HybridPlayer;
import InputGeneration.Input.Input;

public class HybridInputPlayerAdapter implements HybridPlayer {

    private final InputPlayer player;

    public HybridInputPlayerAdapter(InputPlayer player) {
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
