package Messaging;

import Domain.Board.Board;
import Domain.GameEvaluation.GameEvaluator.Api.WinnerProvider;
import Messaging.GameLoopMessengerImp.GameLoopMessengerImp;
import Gaming.GameLoopImp.Api.GameLoop;
import Gaming.GameLoopImp.Game;
import Gaming.MultiPlayer.MultiPlayerMessenger;
import Messaging.MappingPlayerMessenger.MappingMultiPlayerMessenger;
import Messaging.MessageProviders.FixedMessageProvider.FixedMessageProvider;
import Messaging.MessageProviders.GameOverMessageProvider.GameOverMessageProvider;
import Messages.TicTacToeMessages;
import Messaging.MarkToStringMappers.DefaultMarkToStringMapper;
import Messaging.WinnerMessageProviderImp.WinnerMessageProviderImp;
import Messaging.MessagingGameLoop.GameLoopMessenger;
import Utilities.ObjectToStringMapper.Api.ObjectToStringMapper;
import Messaging.MessagingGameLoop.MessagingGameLoop;

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

    public static GameLoop makeMessagingGameLoop(Game game, GameLoopMessenger messenger) {
        GameLoop loop = Gaming.Factory.makeGameLoop(game);
        return new MessagingGameLoop(loop, messenger);
    }
}
