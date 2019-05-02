package Lib.Players.MessagingPlayer;

import Lib.Data.Field.Field;

public class PlayerMessengerSpy extends PlayerMessengerDummy {

    private Field publishedField = null;

    public Field getPublishedField() {
        return publishedField;
    }

    public void publishPlayedMove(Field f) {
        publishedField = f;
    }
}
