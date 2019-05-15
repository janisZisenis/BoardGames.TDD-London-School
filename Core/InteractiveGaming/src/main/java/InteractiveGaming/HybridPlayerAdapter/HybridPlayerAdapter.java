package InteractiveGaming.HybridPlayerAdapter;

import InteractiveGaming.HybridGameImp.HybridPlayer;
import InputGeneration.Input.Input;
import Gaming.GameFacade.Player;

public class HybridPlayerAdapter implements HybridPlayer {

    private final Player player;

    public HybridPlayerAdapter(Player player) {
        this.player = player;
    }

    public boolean isComputer() {
        return true;
    }

    public void playInput(Input input) {
        throw new CannotPlayComputerOnHumansTurn();
    }

    public void play() {
        player.play();
    }
}
