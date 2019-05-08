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
import SequentialGaming.DelegatingGame.Turn;
import SequentialGaming.Factory;
import SequentialGaming.GameLoopImp.Game;
import SequentialGaming.MessagingGameLoop.GameLoop;
import SequentialGaming.MessagingGameLoop.GameLoopMessenger;
import SequentialGaming.MultiTurn.MultiTurn;
import SequentialGaming.MultiTurn.MultiTurnMessenger;
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
        Turn john = Domain.Factory.makeHumanTurn(Mark.John, board, factory);
        Turn haley = Domain.Factory.makeInvincableComputerTurn(Mark.Haley, board, factory);

        DefaultObjectToStringMapper turnMapper = new DefaultObjectToStringMapper(OnePlayerModeMessages.defaultTurnMessage);
        turnMapper.register(john, OnePlayerModeMessages.humanTurnMessage);
        turnMapper.register(haley, OnePlayerModeMessages.computerTurnMessage);
        MultiTurnMessenger turnMessenger = Messaging.Factory.makeMappingMultiTurnMessenger(turnMapper, messenger);

        MultiTurn turn = Factory.makeMessagingMultiTurn(john, turnMessenger);
        turn.add(haley);

        GameOverRule rule = Domain.Factory.makeGameOverRule(board);
        WinningLineProvider provider = Domain.Factory.makeWinningLineProvider(board);
        Renderer renderer = new BoardRenderer(view, provider);
        Game game = Factory.makeGame(rule, turn, renderer);

        GameLoopMessenger loopMessenger = Messaging.Factory.makeTicTacToeGameLoopMessenger(board, messenger);
        GameLoop loop = Factory.makeMessagingGameLoop(game, loopMessenger);

        renderer.render();
        loop.run();
    }

}
