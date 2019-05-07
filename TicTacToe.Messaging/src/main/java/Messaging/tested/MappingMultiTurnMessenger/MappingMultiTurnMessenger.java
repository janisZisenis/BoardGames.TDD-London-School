package Messaging.tested.MappingMultiTurnMessenger;

import Mapping.ObjectToStringMapper;
import SequentialGaming.MultiTurn.MultiTurnMessenger;

public class MappingMultiTurnMessenger implements MultiTurnMessenger {

    private final Messenger messenger;
    private final ObjectToStringMapper mapper;

    public MappingMultiTurnMessenger(ObjectToStringMapper mapper, Messenger messenger) {
        this.messenger = messenger;
        this.mapper = mapper;
    }

    public void publishTurn(Object o) {
        String message = mapper.map(o);
        messenger.publish(message);
    }


}
