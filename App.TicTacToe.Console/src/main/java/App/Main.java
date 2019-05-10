package App;


import Domain.Board.ListenableBoard.ListenableBoard;
import Domain.Data.Mark;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Mapping.MarkToStringMappers.MarkToXOMapper;
import Mapping.ObjectToStringMappers.DefaultObjectToStringMapper;
import Messages.OnePlayerModeMessages;
import Messaging.MessagingBoardListener.HumbleMarkedFieldMessageProviderImp;
import Messaging.MessagingBoardListener.MarkedFieldMessageProvider;
import Messaging.MessagingBoardListener.MessagingBoardListener;
import SequentialGaming.DelegatingGame.GameOverRule;
import SequentialGaming.DelegatingGame.Renderer;
import SequentialGaming.DelegatingGame.Player;
import SequentialGaming.Factory;
import SequentialGaming.GameLoopImp.Game;
import SequentialGaming.MessagingGameLoop.GameLoop;
import SequentialGaming.MessagingGameLoop.GameLoopMessenger;
import SequentialGaming.MultiPlayer.MultiPlayer;
import SequentialGaming.MultiPlayer.MultiPlayerMessenger;
import SequentialRendering.BoardRenderer.BoardRenderer;
import View.ConsoleBoardView;
import View.ConsoleMessenger;

public class Main {

    public static void main(String[] args) {
        ListenableBoard board = Domain.Factory.makeListenableBoard();

        ConsoleBoardView view = new ConsoleBoardView(board, new MarkToXOMapper());
        ConsoleMessenger messenger = new ConsoleMessenger();

        MarkedFieldMessageProvider markedFieldMessageProvider = new HumbleMarkedFieldMessageProviderImp();
        MessagingBoardListener listener = new MessagingBoardListener(messenger, markedFieldMessageProvider);
        board.setListener(listener);

        ConsoleIODeviceFactory factory = new ConsoleIODeviceFactory();
        Player john = Domain.Factory.makeHumanPlayer(Mark.John, board, factory);
        Player haley = Domain.Factory.makeHumbleComputerPlayer(Mark.Haley, board, factory);

        DefaultObjectToStringMapper playerMapper = new DefaultObjectToStringMapper(OnePlayerModeMessages.defaultPlayerMessage);
        playerMapper.register(john, OnePlayerModeMessages.humanPlayerMessage);
        playerMapper.register(haley, OnePlayerModeMessages.computerPlayerMessage);
        MultiPlayerMessenger multiPlayerMessenger = Messaging.Factory.makeMappingMultiPlayerMessenger(playerMapper, messenger);

        MultiPlayer player = Factory.makeMessagingMultiPlayer(john, multiPlayerMessenger);
        player.add(haley);

        GameOverRule rule = Domain.Factory.makeGameOverRule(board);
        WinningLineProvider provider = Domain.Factory.makeWinningLineProvider(board);
        Renderer renderer = new BoardRenderer(view, provider);
        Game game = Factory.makeGame(rule, player, renderer);

        GameLoopMessenger loopMessenger = Messaging.Factory.makeTicTacToeGameLoopMessenger(board, messenger);
        GameLoop loop = Factory.makeMessagingGameLoop(game, loopMessenger);

        renderer.render();
        loop.run();
    }

}
