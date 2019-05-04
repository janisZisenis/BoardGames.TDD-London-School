package App;


import Domain.Board.HashingBoard.HashingBoard;
import Domain.Board.ListenableBoard.ListenableBoard;
import Domain.Board.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Domain.GameEvaluation.GameEvaluator.GameEvaluator;
import Domain.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Domain.InputGenerators.AlertingInputGenerator.InputValidator;
import Domain.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputValidatorImp;
import Domain.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter.RuleChoosingInputAlerter;
import Domain.InputRules.CompositeInputRule.CompositeInputRule;
import Domain.InputRules.FieldExistsRule.FieldExistsRule;
import Domain.InputRules.FieldIsEmptyRule.FieldIsEmptyRule;
import Domain.Messages.AlertingMessages;
import Domain.NumberOfMovesRule.NumberOfMovesRule;
import Gaming.CompositeGameOverRule.CompositeGameOverRule;
import Gaming.WinnerRule.WinnerRule;
import GuiGaming.GuiPlayerImp.GuiPlayerImp;
import GuiGaming.GuiTurn.GuiPlayer;
import GuiGaming.GuiTurn.GuiTwoPlayerTurn;
import GuiGaming.ValidatingInputProcessor.InputProcessor;
import GuiGaming.ValidatingInputProcessor.ValidatingInputProcessor;
import Mappers.MarkToStringMappers.MarkToXOMapper;
import View.FXBoardView;
import View.FXInputAlerter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        ListenableBoard board = new ListenableBoard(new HashingBoard());
        MarkToXOMapper mapper = new MarkToXOMapper();

        CompositeInputRule inputRule = new CompositeInputRule();
        inputRule.add(new FieldIsEmptyRule(board));
        inputRule.add(new FieldExistsRule());
        RuleChoosingInputAlerter alerter = new RuleChoosingInputAlerter();
        alerter.register(new FieldIsEmptyRule(board), new FXInputAlerter(AlertingMessages.inputAlreadyMarked));
        alerter.register(new FieldExistsRule(), new FXInputAlerter(AlertingMessages.inputDoesNotExist));

        InputValidator validator = new InputValidatorImp(inputRule, alerter);

        CompositeGameOverRule gameOverRule = new CompositeGameOverRule();
        EquallyMarkedLineEvaluator lineEvaluator = new EquallyMarkedLineEvaluator(board);
        HumbleLineProvider lineProvider = new HumbleLineProvider();
        GameEvaluator evaluator = new GameEvaluator(lineProvider, lineEvaluator);
        gameOverRule.add(new WinnerRule(evaluator));
        gameOverRule.add(new NumberOfMovesRule(board));


        ///// new to Gui App /////
        GuiPlayer john = new GuiPlayerImp(Mark.John, board);
        GuiPlayer haley = new GuiPlayerImp(Mark.Haley, board);
        GuiTwoPlayerTurn turn = new GuiTwoPlayerTurn(john, haley);
        InputProcessor processor = new ValidatingInputProcessor(turn, validator);
        FXBoardView boardView = new FXBoardView(mapper);
        BoardViewInteractor interactor = new BoardViewInteractor(board, evaluator, processor);
        BoardViewPresenter presenter = new BoardViewPresenter(boardView, interactor);
        boardView.setDelegate(presenter);
        board.setListener(presenter);
        ///// new to Gui App /////

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(boardView));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
