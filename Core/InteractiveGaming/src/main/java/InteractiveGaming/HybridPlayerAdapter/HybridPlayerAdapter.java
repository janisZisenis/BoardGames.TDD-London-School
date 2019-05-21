package InteractiveGaming.HybridPlayerAdapter;

import Gaming.GameFacade.Player;
import Input2D.Input.Input;
import InteractiveGaming.HybridGameImp.HybridPlayer;

public class HybridPlayerAdapter implements HybridPlayer {

    private final Player player;

    public HybridPlayerAdapter(Player player) {
        this.player = player;
    }

    public boolean isInputTurn() {
        return false;
    }

    public void playInput(Input input) {
        throw new CannotPlayWithInput();
    }

    public void play() {
        player.play();
    }

}
