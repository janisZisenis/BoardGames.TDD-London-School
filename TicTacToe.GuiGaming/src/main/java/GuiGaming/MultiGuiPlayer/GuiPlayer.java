package GuiGaming.MultiGuiPlayer;

import Domain.Data.Field.Field;
import InputGeneration.Input.Input;

public interface GuiPlayer {
    void play(Field field);
    void play(Input input);
}
