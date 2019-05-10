package GuiGaming.MultiGuiPlayer;

import Domain.Data.Field.Field;
import GuiGaming.GuiPlayer;

public class GuiPlayerSpy implements GuiPlayer {

    private int timesPlayed = 0;
    private Field playedField;

    public int getPlayedTimes() {
        return timesPlayed;
    }

    public void play(Field field) {
        playedField = field;
        timesPlayed++;
    }

    public Field getPlayedField() {
        return playedField;
    }
}
