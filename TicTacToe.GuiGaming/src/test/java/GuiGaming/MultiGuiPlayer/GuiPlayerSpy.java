package GuiGaming.MultiGuiPlayer;

import Domain.Data.Field.Field;
import InputGeneration.Input.Input;

public class GuiPlayerSpy implements GuiPlayer {

    private int timesPlayed = 0;
    private Field playedField;
    private Input playedInput;

    public int getPlayedTimes() {
        return timesPlayed;
    }

    public Field getPlayedField() {
        return playedField;
    }
    public void play(Field field) {
        playedField = field;
        timesPlayed++;
    }

    public Input getPlayedInput() {
        return playedInput;
    }
    public void play(Input input) {
        playedInput = input;
    }

}
