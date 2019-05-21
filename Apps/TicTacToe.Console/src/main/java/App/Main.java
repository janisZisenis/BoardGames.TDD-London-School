package App;

import ConsoleView.ConsoleBoardView;
import ConsoleView.ConsoleIODeviceFactory;
import ConsoleView.ConsoleMessenger;
import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Data.Mark;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Messaging.GameLoopMessengerImp.MessageProvider;
import Gaming.Factory;
import Gaming.GameFacade.GameOverRule;
import Gaming.GameFacade.Player;
import Gaming.GameFacade.Renderer;
import Gaming.GameLoopImp.Api.GameLoop;
import Gaming.GameLoopImp.Game;
import Gaming.MultiPlayer.MultiPlayer;
import Gaming.MultiPlayer.MultiPlayerMessenger;
import Messaging.MessageProviders.FixedMessageProvider.FixedMessageProvider;
import Messages.TicTacToeMessages;
import Messaging.MarkToStringMappers.MarkToXOMapper;
import Messaging.MessagingBoardListener.HumbleMarkedFieldMessageProviderImp;
import Messaging.MessagingBoardListener.MarkedFieldMessageProvider;
import Messaging.MessagingBoardListener.MessagingBoardListener;
import Messaging.MessagingGameLoop.GameLoopMessenger;
import Rendering.BoardRenderer.BoardRenderer;
import Utilities.ObjectToStringMapper.DefaultObjectToStringMapper;

public class Main {

    public static void main(String[] args) {
        ListenableBoard board = Domain.Factory.makeListenableBoard();

        ConsoleBoardView view = new ConsoleBoardView(board, new MarkToXOMapper());
        ConsoleMessenger messenger = new ConsoleMessenger();

        MessageProvider clearMessageProvider = new FixedMessageProvider(TicTacToeMessages.boardClearedMessage);
        MarkedFieldMessageProvider markedFieldMessageProvider = new HumbleMarkedFieldMessageProviderImp();
        MessagingBoardListener listener = new MessagingBoardListener(messenger, markedFieldMessageProvider, clearMessageProvider);
        board.addListener(listener);

        ConsoleIODeviceFactory factory = new ConsoleIODeviceFactory();
        Player john = Domain.Factory.makeHumanPlayer(Mark.John, board, factory);
        Player haley = Domain.Factory.makeHumbleComputerPlayer(Mark.Haley, board, factory);

        DefaultObjectToStringMapper playerMapper = new DefaultObjectToStringMapper(TicTacToeMessages.defaultPlayerMessage);
        playerMapper.register(john, TicTacToeMessages.humanPlayerMessage);
        playerMapper.register(haley, TicTacToeMessages.computerPlayerMessage);
        MultiPlayerMessenger multiPlayerMessenger = Messaging.Factory.makeMappingMultiPlayerMessenger(playerMapper, messenger);

        MultiPlayer player = Factory.makeMessagingMultiPlayer(john, multiPlayerMessenger);
        player.add(haley);

        GameOverRule rule = Domain.Factory.makeGameOverRule(board);
        WinningLineProvider provider = Domain.Factory.makeWinningLineProvider(board);
        Renderer renderer = new BoardRenderer(view, provider);
        Game game = Factory.makeGame(rule, player, renderer);

        GameLoopMessenger loopMessenger = Messaging.Factory.makeTicTacToeGameLoopMessenger(board, messenger);
        GameLoop loop = Messaging.Factory.makeMessagingGameLoop(game, loopMessenger);

        renderer.render();
        loop.run();
    }

}
