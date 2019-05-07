package Messaging.tested.MappingTurnMessenger;

import Mapping.ObjectToStringMapper;
import SequentialGaming.MultiTurn.MultiTurnMessenger;

public class MappingTurnMessenger implements MultiTurnMessenger {

    private final Messenger messenger;
    private final ObjectToStringMapper mapper;

    public MappingTurnMessenger(Messenger messenger, ObjectToStringMapper mapper) {
        this.messenger = messenger;
        this.mapper = mapper;
    }

    public void publishTurn(Object o) {
        String message = mapper.map(o);
        messenger.publish(message);
    }


}
