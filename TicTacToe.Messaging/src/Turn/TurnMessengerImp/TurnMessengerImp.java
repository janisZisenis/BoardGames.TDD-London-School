package Turn.TurnMessengerImp;

import Game.GameMessengerImp.Messenger;
import Mapping.ObjectToStringMapper.ObjectToStringMapper;
import Turn.MessagingTurn.TurnMessenger;

public class TurnMessengerImp implements TurnMessenger {

    private final Messenger messenger;
    private final ObjectToStringMapper mapper;

    public TurnMessengerImp(Messenger messenger, ObjectToStringMapper mapper) {
        this.messenger = messenger;
        this.mapper = mapper;
    }

    public void publishTurnMessageFor(Object player) {
        throwIfIsNotMappable(player);

        String message = mapper.map(player);
        messenger.publish(message);
    }

    private void throwIfIsNotMappable(Object player) {
        if(!mapper.isMappable(player))
            throw new NoTurnMessageForObjectAvailable();
    }

}
