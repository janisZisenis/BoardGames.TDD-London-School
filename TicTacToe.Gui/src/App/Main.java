package App;


import Board.HashingBoard.HashingBoard;
import Board.Mark;
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

        CompositeInputRule rule = new CompositeInputRule();
        rule.add(new FieldIsEmptyRule(board));
        rule.add(new FieldExistsRule());
        RuleChoosingInputAlerter alerter = new RuleChoosingInputAlerter();
        alerter.register(new FieldIsEmptyRule(board), new FXInputAlerter(AlertingMessages.inputAlreadyMarked));
        alerter.register(new FieldExistsRule(), new FXInputAlerter(AlertingMessages.inputDoesNotExist));

        GuiPlayer john = new GuiPlayerImp(Mark.John, board);
        GuiPlayer haley = new GuiPlayerImp(Mark.Haley, board);
        GuiTwoPlayerTurn turn = new GuiTwoPlayerTurn(john, haley);

        InputValidator validator = new InputValidatorImp(rule, alerter);
        InputProcessor processor = new ValidatingInputProcessor(turn, validator);

        FXBoardView boardView = new FXBoardView(board, mapper);
        BoardPresenter presenter = new BoardPresenter(boardView, processor, board);
        boardView.setDelegate(presenter);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(boardView));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
