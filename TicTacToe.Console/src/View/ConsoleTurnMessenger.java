package View;

import Lib.ObjectToStringMapper.ObjectToStringMapper;
import Lib.TwoPlayerTurn.MessagingTwoPlayerTurn.TurnMessenger;

public class ConsoleTurnMessenger implements TurnMessenger {

    private final ObjectToStringMapper mapper;

    public ConsoleTurnMessenger(ObjectToStringMapper mapper) {
        this.mapper = mapper;
    }

    public void publishTurnMessageFor(Object player) {
        String message = mapper.map(player);
        System.out.println(message);
    }
}
