package Messaging;

import Domain.Board.Board;
import Domain.GameEvaluation.GameEvaluator.Api.WinnerProvider;
import Mapping.MarkToStringMappers.DefaultMarkToStringMapper;
import Mapping.ObjectToStringMapper;
import Messages.TicTacToeMessages;
import Messaging.GameLoopMessengerImp.GameLoopMessengerImp;
import Messaging.MappingPlayerMessenger.MappingMultiPlayerMessenger;
import Messaging.MappingPlayerMessenger.Messenger;
import Messaging.MessageProviders.FixedMessageProvider.FixedMessageProvider;
import Messaging.MessageProviders.GameOverMessageProvider.GameOverMessageProvider;
import Messaging.WinnerMessageProviderImp.WinnerMessageProviderImp;
import Gaming.MessagingGameLoop.GameLoopMessenger;
import Gaming.MultiPlayer.MultiPlayerMessenger;

public abstract class Factory {

    public static MultiPlayerMessenger makeMappingMultiPlayerMessenger(ObjectToStringMapper mapper, Messenger messenger) {
        return new MappingMultiPlayerMessenger(mapper, messenger);
    }

    public static GameLoopMessenger makeTicTacToeGameLoopMessenger(Board board, Messenger messenger) {
        FixedMessageProvider startProvider = new FixedMessageProvider(TicTacToeMessages.salutation);

        WinnerProvider winnerProvider = Domain.Factory.makeWinnerProvider(board);
        DefaultMarkToStringMapper mapper = new DefaultMarkToStringMapper(TicTacToeMessages.humanWinMessage, TicTacToeMessages.computerWinMessage);
        WinnerMessageProviderImp winnerMessageProvider = new WinnerMessageProviderImp(winnerProvider, mapper);
        FixedMessageProvider drawMessageProvider = new FixedMessageProvider(TicTacToeMessages.drawMessage);
        GameOverMessageProvider endProvider = new GameOverMessageProvider(winnerMessageProvider, drawMessageProvider);

        return new GameLoopMessengerImp(messenger, startProvider, endProvider);
    }
}
