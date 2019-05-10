package GuiGaming.PlayingInputProcessor;

import Domain.Data.Field.Field;
import GuiGaming.GuiPlayer;
import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;

public class PlayingInputProcessor implements InputProcessor {

    private final GuiPlayer player;

    public PlayingInputProcessor(GuiPlayer player) {
        this.player = player;
    }

    public void process(Input input) {
        int row = input.getRow();
        int col = input.getColumn();
        Field f = new Field(row, col);

        player.play(f);
    }
}
