package App;


import Lib.CLI.View.InputGenerators.ConsoleInputAlerter;
import Lib.CLI.View.InputGenerators.ConsoleInputGenerator;
import Lib.CLI.View.InputGenerators.ConsoleTurnMessageView;
import Lib.CLI.View.TicTacToeView.AlertingMessages;
import Lib.CLI.View.TicTacToeView.ConsoleBoardView;
import Lib.Data.Mark;
import Lib.Model.Board.Board;
import Lib.Model.Board.HashingBoard.HashingBoard;
import Lib.Model.BoardRenderer.BoardRenderer;
import Lib.Model.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.GameEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.LineEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.LineProvider;
import Lib.Model.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Lib.Model.RenderingGameLoop.GameImp.GameOverRule;
import Lib.Model.RenderingGameLoop.GameImp.Turn;
import Lib.Model.RenderingGameLoop.GameImp.TwoPlayerTurn.Player;
import Lib.Model.RenderingGameLoop.GameImp.TwoPlayerTurn.VerboseTwoPlayerTurn.VerboseTwoPlayerTurn;
import Lib.Model.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;
import Lib.Model.GameOverRules.NumberOfMovesRule.NumberOfMovesRule;
import Lib.Model.GameOverRules.WinnerRule.WinnerRule;
import Lib.Model.InputGenerators.RandomInputGenerator.RandomInputGenerator;
import Lib.Model.InputGenerators.ValidatingInputGenerator.ValidatingInputGenerator;
import Lib.Model.InputGenerators.VerboseValidatingInputGenerator.InputReferee;
import Lib.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.InputAlerter;
import Lib.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.InputRefereeImp;
import Lib.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.InputRule;
import Lib.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.RuleChoosingInputAlerter.RuleChoosingInputAlerter;
import Lib.Model.InputGenerators.VerboseValidatingInputGenerator.VerboseValidatingInputGenerator;
import Lib.Model.InputRules.CompositeInputRule.CompositeInputRule;
import Lib.Model.InputRules.FieldExistsRule.FieldExistsRule;
import Lib.Model.InputRules.FieldIsEmptyRule.FieldIsEmptyRule;
import Lib.Model.Players.InputGenerator;
import Lib.Model.Players.PlayerContext;
import Lib.Model.Players.PlayerImp;
import Lib.Model.RenderingGameLoop.Game;
import Lib.Model.RenderingGameLoop.GameImp.GameImp;
import Lib.Model.RenderingGameLoop.GameImp.Renderer;
import Lib.Model.RenderingGameLoop.RenderingGameLoop;
import Lib.Presentation.BoardPresenter.WinningLineProvider;
import Lib.Presentation.MarkToStringMapper.MarkToStringMapper;
import Lib.Presentation.MarkToStringMapper.MarkToXOMapper;

public class TicTacToeFactory {

    public WinningLineProvider makeWinningLineProvider(Board board) {
        LineProvider provider = new HumbleLineProvider();
        LineEvaluator evaluator = new EquallyMarkedLineEvaluator(board);
        return new GameEvaluator(provider, evaluator);
    }

    public RenderingGameLoop makeRenderingGameLoop(Board board) {
        Turn turn = makeTurn(board);
        GameOverRule rule = makeTicTacToeGameOverRule(board);
        Renderer renderer = makeBoardRenderer(board);
        Game game = new GameImp(turn, rule, renderer);

        return new RenderingGameLoop(game);
    }

    private Renderer makeBoardRenderer(Board board) {
        MarkToStringMapper mapper = new MarkToXOMapper();
        ConsoleBoardView view = new ConsoleBoardView(board, mapper);
        WinningLineProvider provider = makeWinningLineProvider(board);
        return new BoardRenderer(view, provider);
    }

    private Turn makeTurn(Board board) {
        Player john = makeHumanPlayer(board, Mark.John);
        Player haley = makeComputerPlayer(board, Mark.Haley);

        ConsoleTurnMessageView view = new ConsoleTurnMessageView();
        view.register(john, "X");
        view.register(haley, "O");
        return new VerboseTwoPlayerTurn(john, haley, view);
    }

    public Player makeHumanPlayer(Board board, Mark mark) {
        InputGenerator generator = makeConsoleInputGenerator(board);
        PlayerContext context = new PlayerContext(generator, board, mark);

        return new PlayerImp(context);
    }

    public Player makeComputerPlayer(Board board, Mark mark) {
        InputGenerator generator = makeComputerInputGenerator(board);
        PlayerContext context = new PlayerContext(generator, board, mark);

        return new PlayerImp(context);
    }

    private InputGenerator makeComputerInputGenerator(Board board) {
        InputGenerator generator = new RandomInputGenerator();
        InputRule rule = makeInputRule(board);
        return new ValidatingInputGenerator(generator, rule);
    }

    private InputGenerator makeConsoleInputGenerator(Board board) {
        InputReferee referee = makeInputReferee(board);
        InputGenerator generator = makeConsoleGenerator();
        return new VerboseValidatingInputGenerator(generator, referee);
    }

    private InputReferee makeInputReferee(Board board) {
        InputAlerter alerter = makeInputAlerter(board);
        InputRule rule = makeInputRule(board);

        return new InputRefereeImp(rule, alerter);
    }

    private InputAlerter makeInputAlerter(Board board) {
        InputRule existsRule = makeFieldExistsRule();
        InputAlerter existsAlerter = makeFieldExistsAlerter();
        InputRule isFreeRule = makeFieldIsEmptyRule(board);
        InputAlerter isFreeAlerter = makeFieldIsEmptyAlerter();

        RuleChoosingInputAlerter choosing = new RuleChoosingInputAlerter();
        choosing.register(existsRule, existsAlerter);
        choosing.register(isFreeRule, isFreeAlerter);
        return choosing;
    }

    private InputRule makeFieldExistsRule() {
        return new FieldExistsRule();
    }

    private InputAlerter makeFieldExistsAlerter() {
        return new ConsoleInputAlerter(AlertingMessages.inputDoesNotExist);
    }

    private InputRule makeFieldIsEmptyRule(Board board) {
        return new FieldIsEmptyRule(board);
    }

    private InputAlerter makeFieldIsEmptyAlerter() {
        return new ConsoleInputAlerter(AlertingMessages.inputAlreadyMarked);
    }

    private InputRule makeInputRule(Board board) {
        InputRule existsRule = makeFieldExistsRule();
        InputRule isFreeRule = makeFieldIsEmptyRule(board);

        CompositeInputRule composite = new CompositeInputRule();
        composite.add(existsRule);
        composite.add(isFreeRule);

        return composite;
    }

    private InputGenerator makeConsoleGenerator() {
        return new ConsoleInputGenerator();
    }



    public GameOverRule makeTicTacToeGameOverRule(Board board) {
        GameOverRule numberOfMovesRule = makeNumberOfMovesRule(board);
        GameOverRule winningLineRule = makeWinningLineRule(board);

        CompositeGameOverRule rule = new CompositeGameOverRule();
        rule.add(numberOfMovesRule);
        rule.add(winningLineRule);

        return rule;
    }

    private GameOverRule makeNumberOfMovesRule(Board board) {
        return new NumberOfMovesRule(board);
    }

    public GameOverRule makeWinningLineRule(Board board) {
        EquallyMarkedLineEvaluator evaluator = new EquallyMarkedLineEvaluator(board);
        HumbleLineProvider provider = new HumbleLineProvider();
        GameEvaluator winningLineProvider = new GameEvaluator(provider, evaluator);
        return new WinnerRule(winningLineProvider);
    }
    
    public Board makeBoard() {
        return new HashingBoard();
    }

}
