package App;


import Lib.CLI.View.InputGenerators.ConsoleInputAlerter;
import Lib.CLI.View.InputGenerators.ConsoleInputGenerator;
import Lib.CLI.View.InputGenerators.ConsoleTurnMessageView;
import Lib.CLI.View.TicTacToeView.AlertingMessages;
import Lib.CLI.View.TicTacToeView.ConsoleBoardView;
import Lib.CLI.View.TicTacToeView.ConsoleReceptionist;
import Lib.Data.Mark;
import Lib.Model.Board.Board;
import Lib.Model.Board.HashingBoard.HashingBoard;
import Lib.Model.BoardRenderer.BoardRenderer;
import Lib.Model.BoardRenderer.WinningLineProvider;
import Lib.Model.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.GameEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.LineEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.LineProvider;
import Lib.Model.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Lib.Model.GameLoopImp.Game;
import Lib.Model.GameLoopImp.GameImp.GameImp;
import Lib.Model.GameLoopImp.GameImp.GameOverRule;
import Lib.Model.GameLoopImp.GameImp.Renderer;
import Lib.Model.GameLoopImp.GameImp.Turn;
import Lib.Model.GameLoopImp.GameImp.TwoPlayerTurn.Player;
import Lib.Model.GameLoopImp.GameImp.TwoPlayerTurn.VerboseTwoPlayerTurn.VerboseTwoPlayerTurn;
import Lib.Model.GameLoopImp.GameLoopImp;
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
import Lib.Model.TicTacToe.TicTacToe;
import Lib.Presentation.MarkToStringMapper.MarkToStringMapper;
import Lib.Presentation.MarkToStringMapper.MarkToXOMapper;

public class TicTacToeFactory {

    public TicTacToe makeTicTacToe() {

        Board board = new HashingBoard();

        ConsoleReceptionist receptionist = new ConsoleReceptionist();
        MarkToStringMapper mapper = new MarkToXOMapper();
        ConsoleBoardView view = new ConsoleBoardView(board, mapper);
        LineProvider lineProvider = new HumbleLineProvider();
        LineEvaluator evaluator = new EquallyMarkedLineEvaluator(board);
        WinningLineProvider provider = new GameEvaluator(lineProvider, evaluator);
        Renderer renderer = new BoardRenderer(view, provider);

        InputRule existsRule = new FieldExistsRule();
        InputRule isFreeRule = new FieldIsEmptyRule(board);
        InputAlerter existsAlerter = new ConsoleInputAlerter(AlertingMessages.inputDoesNotExist);
        InputAlerter isFreeAlerter = new ConsoleInputAlerter(AlertingMessages.inputAlreadyMarked);

        RuleChoosingInputAlerter alerter = new RuleChoosingInputAlerter();
        alerter.register(existsRule, existsAlerter);
        alerter.register(isFreeRule, isFreeAlerter);

        CompositeInputRule inputRule = new CompositeInputRule();
        inputRule.add(existsRule);
        inputRule.add(isFreeRule);

        InputReferee referee = new InputRefereeImp(inputRule, alerter);
        InputGenerator consoleGenerator = new ConsoleInputGenerator();
        InputGenerator humanGenerator = new VerboseValidatingInputGenerator(consoleGenerator, referee);
        PlayerContext johnContext = new PlayerContext(humanGenerator, board, Mark.John);
        Player john = new PlayerImp(johnContext);

        InputGenerator randomGenerator = new RandomInputGenerator();
        InputGenerator computerGenerator = new ValidatingInputGenerator(randomGenerator, inputRule);
        PlayerContext haleyContext = new PlayerContext(computerGenerator, board, Mark.Haley);
        Player haley = new PlayerImp(haleyContext);

        ConsoleTurnMessageView turnMessageView = new ConsoleTurnMessageView();
        turnMessageView.register(john, "X");
        turnMessageView.register(haley, "O");
        Turn turn = new VerboseTwoPlayerTurn(john, haley, turnMessageView);

        CompositeGameOverRule gameOverRule = new CompositeGameOverRule();
        GameOverRule numberOfMovesRule = new NumberOfMovesRule(board);
        gameOverRule.add(numberOfMovesRule);
        GameEvaluator winningLineProvider = new GameEvaluator(lineProvider, evaluator);
        GameOverRule winningLineRule = new WinnerRule(winningLineProvider);
        gameOverRule.add(winningLineRule);

        Game game = new GameImp(turn, gameOverRule, renderer);

        GameLoopImp loop = new GameLoopImp(game);
        return new TicTacToe(receptionist, renderer, loop);
    }

}
