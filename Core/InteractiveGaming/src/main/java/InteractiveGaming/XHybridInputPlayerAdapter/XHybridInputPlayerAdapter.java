package InteractiveGaming.XHybridInputPlayerAdapter;

import Input2D.Input.Input;
import InteractiveGaming.XMultiHybridPlayer.XHybridPlayer;

public class XHybridInputPlayerAdapter implements XHybridPlayer {

    private final InputPlayer player;

    public XHybridInputPlayerAdapter(InputPlayer player) {
        this.player = player;
    }

    public void play() {
        throw new CannotPlayWithoutInput();
    }

    public void playInput(Input input) {
        player.play(input);
    }

    public boolean isInputTurn() {
        return true;
    }

}
