package InteractiveGaming.HybridInputPlayerAdapter;

import InteractiveGaming.HybridGameImp.HybridPlayer;
import InputGeneration.Input.Input;

public class HybridInputPlayerAdapter implements HybridPlayer {

    private final InputPlayer player;

    public HybridInputPlayerAdapter(InputPlayer player) {
        this.player = player;
    }

    public boolean isComputer() {
        return false;
    }

    public void play() {
        throw new CannotPlayComputerOnHumansTurn();
    }

    public void playInput(Input input) {
        player.play(input);
    }
}
