package Messaging;

import Mapping.ObjectToStringMapper;
import Messaging.tested.MappingMultiTurnMessenger.MappingMultiTurnMessenger;
import Messaging.tested.MappingMultiTurnMessenger.Messenger;
import SequentialGaming.MultiTurn.MultiTurnMessenger;

public abstract class Factory {

    public static MultiTurnMessenger makeMappingMultiTurnMessenger(ObjectToStringMapper mapper, Messenger messenger) {
        return new MappingMultiTurnMessenger(mapper, messenger);
    }

}
