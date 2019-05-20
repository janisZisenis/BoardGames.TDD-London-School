package InteractiveGaming.HybridInputPlayerAdapter;

import InteractiveGaming.HybridGameImp.HybridPlayer;
import Input2D.Input.Input;

public class HybridInputPlayerAdapter implements HybridPlayer {

    private final InputPlayer player;

    public HybridInputPlayerAdapter(InputPlayer player) {
        this.player = player;
    }

    public boolean isNotInputTurn() {
        return false;
    }

    public void play() {
        throw new CannotPlayComputerOnHumansTurn();
    }

    public void playInput(Input input) {
        player.play(input);
    }
}
