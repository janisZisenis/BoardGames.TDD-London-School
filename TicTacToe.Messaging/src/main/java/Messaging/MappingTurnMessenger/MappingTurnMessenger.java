package Messaging.MappingTurnMessenger;

import Mapping.ObjectToStringMapper;
import Messaging.Messenger;
import SequentialGaming.MultiTurn.MultiTurnMessenger;

public class MappingTurnMessenger implements MultiTurnMessenger {

    private final Messenger messenger;
    private final ObjectToStringMapper mapper;

    public MappingTurnMessenger(Messenger messenger, ObjectToStringMapper mapper) {
        this.messenger = messenger;
        this.mapper = mapper;
    }

    public void publishTurn(Object player) {
        throwIfIsNotMappable(player);

        String message = mapper.map(player);
        messenger.publish(message);
    }

    private void throwIfIsNotMappable(Object player) {
        if(!mapper.isMappable(player))
            throw new MultiTurnMessenger.NoTurnMessageForObjectAvailable();
    }

}
