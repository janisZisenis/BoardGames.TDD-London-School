package View;

import Lib.Data.Field.Field;
import Lib.Data.Mark;
import Lib.MarkToStringMapper.MarkToStringMapper;
import Lib.Players.MessagingPlayer.PlayerMessenger;

public class ConsolePlayerMessenger implements PlayerMessenger {

    private final MarkToStringMapper mapper;

    public ConsolePlayerMessenger(MarkToStringMapper mapper) {
        this.mapper = mapper;
    }

    public void publishPlayedMove(Mark m, Field f) {
        String message = getMessage(m, f);
        System.out.println(message);
    }

    private String getMessage(Mark m, Field f) {
        String mark = mapper.map(m);
        int row = f.getRow();
        int col = f.getColumn();

        return mark + " marked the field [" + row + ", " + col + "]";
    }

}
