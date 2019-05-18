package MappingPlayerMessenger;

import Gaming.MultiPlayer.MultiPlayerMessenger;
import Utilities.ObjectToStringMapper.Api.ObjectToStringMapper;

public class MappingMultiPlayerMessenger implements MultiPlayerMessenger {

    private final Messenger messenger;
    private final ObjectToStringMapper mapper;

    public MappingMultiPlayerMessenger(ObjectToStringMapper mapper, Messenger messenger) {
        this.messenger = messenger;
        this.mapper = mapper;
    }

    public void publishPlayer(Object o) {
        String message = mapper.map(o);
        messenger.publish(message);
    }


}
