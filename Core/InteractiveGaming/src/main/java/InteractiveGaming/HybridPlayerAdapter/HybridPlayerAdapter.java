package InteractiveGaming.HybridPlayerAdapter;

import InteractiveGaming.HybridGameImp.HybridPlayer;
import Input2D.Input.Input;
import Gaming.GameFacade.Player;

public class HybridPlayerAdapter implements HybridPlayer {

    private final Player player;

    public HybridPlayerAdapter(Player player) {
        this.player = player;
    }

    public boolean isNotInputTurn() {
        return true;
    }

    public void playInput(Input input) {
        throw new CannotPlayWithInput();
    }

    public void play() {
        player.play();
    }
}
