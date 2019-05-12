package GuiGaming.MultiGuiPlayer;

import Domain.Data.Field.Field;

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
