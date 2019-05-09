package Messaging;

import Domain.Board.Board;
import Domain.GameEvaluation.GameEvaluator.Api.WinnerProvider;
import Mapping.MarkToStringMappers.DefaultMarkToStringMapper;
import Mapping.ObjectToStringMapper;
import Messages.OnePlayerModeMessages;
import Messaging.GameLoopMessengerImp.GameLoopMessengerImp;
import Messaging.MappingMultiTurnMessenger.MappingMultiPlayerMessenger;
import Messaging.MappingMultiTurnMessenger.Messenger;
import Messaging.MessageProviders.FixedMessageProvider.FixedMessageProvider;
import Messaging.MessageProviders.GameOverMessageProvider.GameOverMessageProvider;
import Messaging.WinnerMessageProviderImp.WinnerMessageProviderImp;
import SequentialGaming.MessagingGameLoop.GameLoopMessenger;
import SequentialGaming.MultiPlayer.MultiPlayerMessenger;

public abstract class Factory {

    public static MultiPlayerMessenger makeMappingMultiPlayerMessenger(ObjectToStringMapper mapper, Messenger messenger) {
        return new MappingMultiPlayerMessenger(mapper, messenger);
    }

    public static GameLoopMessenger makeTicTacToeGameLoopMessenger(Board board, Messenger messenger) {
        FixedMessageProvider startProvider = new FixedMessageProvider(OnePlayerModeMessages.salutation);

        WinnerProvider winnerProvider = Domain.Factory.makeWinnerProvider(board);
        DefaultMarkToStringMapper mapper = new DefaultMarkToStringMapper(OnePlayerModeMessages.humanWinMessage, OnePlayerModeMessages.computerWinMessage);
        WinnerMessageProviderImp winnerMessageProvider = new WinnerMessageProviderImp(winnerProvider, mapper);
        FixedMessageProvider drawMessageProvider = new FixedMessageProvider(OnePlayerModeMessages.drawMessage);
        GameOverMessageProvider endProvider = new GameOverMessageProvider(winnerMessageProvider, drawMessageProvider);

        return new GameLoopMessengerImp(messenger, startProvider, endProvider);
    }
}
