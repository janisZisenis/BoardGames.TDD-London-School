package Messaging.Player.MessagingPlayer;

import Lib.Data.Field.Field;

public class PlayerMessengerSpy extends PlayerMessengerDummy {

    private Field publishedField = null;

    public Field getPublishedField() {
        return publishedField;
    }

    public void publishMarkedField(Field f) {
        publishedField = f;
    }
}
