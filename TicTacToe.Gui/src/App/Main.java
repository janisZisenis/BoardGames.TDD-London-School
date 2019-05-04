package App;


import Board.HashingBoard.HashingBoard;
import Board.Mark;
import Gaming.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Gaming.GameEvaluation.GameEvaluator.GameEvaluator;
import Gaming.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Gaming.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;
import Gaming.GameOverRules.NumberOfMovesRule.NumberOfMovesRule;
import Gaming.GameOverRules.WinnerRule.WinnerRule;
import Gaming.InputGenerators.AlertingInputGenerator.InputValidator;
import Gaming.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputValidatorImp;
import Gaming.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter.RuleChoosingInputAlerter;
import Gaming.InputRules.CompositeInputRule.CompositeInputRule;
import Gaming.InputRules.FieldExistsRule.FieldExistsRule;
import Gaming.InputRules.FieldIsEmptyRule.FieldIsEmptyRule;
import Gaming.Messages.AlertingMessages;
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
        HashingBoard board = new HashingBoard();
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
        FXBoardView boardView = new FXBoardView(board, mapper);
        BoardPresenter presenter = new BoardPresenter(boardView, processor, gameOverRule, evaluator);
        boardView.setDelegate(presenter);
        ///// new to Gui App /////

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(boardView));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
