package InteractiveGaming.XHybridPlayerAdapter;

import Gaming.GameFacade.Player;
import Input2D.Input.Input;
import InteractiveGaming.XMultiHybridPlayer.XHybridPlayer;

public class XHybridPlayerAdapter implements XHybridPlayer {

    private final Player player;

    public XHybridPlayerAdapter(Player player) {
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
