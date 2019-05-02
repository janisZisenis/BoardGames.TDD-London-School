package Lib.Players.MessagingPlayer;

import Lib.Data.Field.Field;
import Lib.Data.Mark;

public class PlayerMessengerSpy extends PlayerMessengerDummy {

    private Field publishedField = null;
    private Mark publishedMark = null;

    public Field getPublishedField() {
        return publishedField;
    }

    public void publishPlayedMove(Mark m, Field f) {
        publishedMark = m;
        publishedField = f;
    }

    public Mark getPublishedMark() {
        return publishedMark;
    }
}
