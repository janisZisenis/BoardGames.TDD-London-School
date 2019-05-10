package App;

import Domain.Board.Board;
import Domain.Board.ListenableBoard.BoardListener;
import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.GameEvaluation.GameEvaluator.GameEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineProvider;
import Domain.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import Domain.InputGeneration.InputValidators.GameOverValidator.GameOverValidator;
import GuiGaming.GuiPlayer;
import GuiGaming.GuiTicTacToePlayer.GuiTicTacToePlayer;
import GuiGaming.MultiGuiPlayer.MultiGuiPlayer;
import GuiGaming.PlayingInputProcessor.PlayingInputProcessor;
import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;
import InputGeneration.ValidInputGenerator.InputAlerter;
import InputGeneration.ValidInputGenerator.InputValidator;
import Messages.AlertingMessages;
import SequentialGaming.DelegatingGame.GameOverRule;
import View.FXBoardView;
import View.FXInputAlerter;

public class TicTacToePresenter implements BoardViewDelegate, BoardListener {

    private final FXBoardView view;
    private final Board board;
    private final InputProcessor processor;
    private final WinningLineProvider provider;

    public void onFieldUpdated(Field field) {
        updateField(field);

        if(provider.hasWinningLine()) {
            Line line = provider.getWinningLine();
            showWinningLine(line);
        }

    }

    private void showWinningLine(Line line) {
        view.showWinningLine(line);
    }

    private void updateField(Field field) {
        if(board.isMarked(field)) {
            Mark m = board.getMarkAt(field);
            view.setFieldMark(field, m);
        }
    }

    public TicTacToePresenter(FXBoardView view, Board board) {
        this.board = board;
        this.view = view;
        this.processor = makeProcessor();
        this.provider = makeEvaluator();
    }

    public void onTileClicked(int row, int column) {
        Input input = new Input(row, column);
        processor.process(input);
    }

    private InputProcessor makeProcessor() {
        GuiPlayer first = new GuiTicTacToePlayer(Mark.John, board);
        GuiPlayer  second = new GuiTicTacToePlayer(Mark.Haley, board);

        MultiGuiPlayer player = new MultiGuiPlayer(first);
        player.add(second);

        GameOverRule rule = Domain.Factory.makeGameOverRule(board);
        InputValidator emptyValidator = new FieldIsEmptyValidator(board);
        InputAlerter alerter = new FXInputAlerter(AlertingMessages.inputAlreadyMarked);
        InputValidator gameOverValidator = new GameOverValidator(rule);

        InputProcessor processor = new PlayingInputProcessor(player);
        processor = InputGeneration.Factory.makeAlertingInputProcessor(processor, emptyValidator, alerter);
        processor = InputGeneration.Factory.makeValidatingInputProcessor(processor, gameOverValidator);

        return processor;
    }

    private WinningLineProvider makeEvaluator() {
        LineEvaluator lineEvaluator = new EquallyMarkedLineEvaluator(board);
        LineProvider lineProvider = new HumbleLineProvider();
        return new GameEvaluator(lineProvider, lineEvaluator);
    }

}
