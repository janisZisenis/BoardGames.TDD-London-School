package App;


import Domain.Board.HashingBoard.HashingBoard;
import Domain.Board.ListenableBoard.ListenableBoard;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Domain.GameEvaluation.GameEvaluator.GameEvaluator;
import Domain.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Domain.InputGeneration.InputValidators.FieldExistsValidator.FieldExistsValidator;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import Domain.NumberOfMovesRule.NumberOfMovesRule;
import Gaming.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;
import Gaming.GameOverRules.WinnerRule.WinnerRule;
import GuiGaming.GuiPlayerImp.GuiPlayerImp;
import GuiGaming.GuiTurn.GuiPlayer;
import GuiGaming.GuiTurn.GuiTwoPlayerTurn;
import InputGeneration.CompositeInputValidator.CompositeInputValidator;
import InputGeneration.MappingInputAlerter.MappingInputAlerter;
import Mapping.MarkToStringMappers.MarkToXOMapper;
import Messages.AlertingMessages;
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

        CompositeInputValidator inputValidator = new CompositeInputValidator();
        inputValidator.add(new FieldIsEmptyValidator(board));
        inputValidator.add(new FieldExistsValidator());
        MappingInputAlerter alerter = new MappingInputAlerter();
        alerter.register(new FieldIsEmptyValidator(board), new FXInputAlerter(AlertingMessages.inputAlreadyMarked));
        alerter.register(new FieldExistsValidator(), new FXInputAlerter(AlertingMessages.inputDoesNotExist));


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
        FXBoardView boardView = new FXBoardView(mapper);
//        InputProcessor processor = new ValidatingInputProcessor(turn, validator);
//        BoardViewInteractor interactor = new BoardViewInteractor(board, evaluator, processor);
//        BoardViewPresenter presenter = new BoardViewPresenter(boardView, interactor);
//        boardView.setDelegate(presenter);
//        board.setListener(presenter);
        ///// new to Gui App /////

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(boardView));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
