package GuiGaming.ValidatingInputProccesor;

import Domain.Data.Field.Field;
import GuiGaming.ValidatingInputProcessor.GuiTurn;

public class GuiTurnSpy implements GuiTurn {

    private boolean didPlay = false;
    private Field playedField;

    public Field getPlayedField() {
        return playedField;
    }
    public void play(Field field) {
        didPlay = true;
        playedField = field;
    }

    public boolean hasPlayed() {
        return didPlay;
    }
}
