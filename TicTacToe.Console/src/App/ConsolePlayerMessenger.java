package App;

import Lib.Data.Field.Field;
import Lib.Players.MessagingPlayer.PlayerMessenger;

public class ConsolePlayerMessenger implements PlayerMessenger {

    public void publishPlayedMove(Field f) {
        String message = getMessage(f);
        System.out.println(message);
    }

    private String getMessage(Field f) {
        int row = f.getRow();
        int col = f.getColumn();

        return "Field [" + row + ", " + col + "] was marked!";
    }

}
