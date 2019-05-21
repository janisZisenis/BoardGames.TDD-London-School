package InteractiveGaming.HybridInputPlayerAdapter;

import Input2D.Input.Input;
import InteractiveGaming.HybridExceptions.CanNotPlayWithoutInput;
import InteractiveGaming.HybridGameImp.HybridPlayer;

public class HybridInputPlayerAdapter implements HybridPlayer {

    private final InputPlayer player;

    public HybridInputPlayerAdapter(InputPlayer player) {
        this.player = player;
    }

    public void play() {
        throw new CanNotPlayWithoutInput();
    }

    public void playInput(Input input) {
        player.play(input);
    }

    public boolean isInputTurn() {
        return true;
    }

}
