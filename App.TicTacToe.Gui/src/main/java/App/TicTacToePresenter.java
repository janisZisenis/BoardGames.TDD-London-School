package App;

import Domain.Board.Board;
import Domain.Board.BoardDecorators.ListenableBoard.BoardListener;
import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.IODeviceFactory;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import GuiGaming.GuiTicTacToePlayer.GuiTicTacToePlayer;
import GuiGaming.MultiGuiPlayer.GuiPlayer;
import GuiGaming.Presentation.BoardPresenter.Api.BoardViewDelegate;
import GuiGaming.Presentation.BoardPresenter.BoardView;
import InputGeneration.Input.Input;
import Messages.AlertingMessages;
import SequentialGaming.GameFacade.GameOverRule;
import SequentialGaming.GameFacade.Player;
import Utilities.CyclicListIterator.CyclicListIterator;
import View.FXInputAlerter;

import java.util.LinkedList;
import java.util.List;

public class TicTacToePresenter implements BoardViewDelegate, BoardListener {

    private final BoardView view;
    private final Board board;

    private GuiPlayer johnHuman;
    private GuiPlayer haleyHuman;
    private Player johnCPU;
    private Player haleyCPU;


    private final GameOverRule rule;
    private final WinningLineProvider provider;
    private final FieldIsEmptyValidator emptyValidator;
    private final FXInputAlerter alerter;

    private final CyclicListIterator<Object> it;

    private void initPlayers(Board board) {
        johnHuman = new GuiTicTacToePlayer(Mark.John, board);
        haleyHuman = new GuiTicTacToePlayer(Mark.Haley, board);

        IODeviceFactory factory = new FXIODeviceFactory();
        johnCPU = Domain.Factory.makeInvincibleComputerPlayer(Mark.John, board, factory);
        haleyCPU = Domain.Factory.makeInvincibleComputerPlayer(Mark.Haley, board, factory);
    }


    public TicTacToePresenter(Board board, BoardView view) {
        this.board = board;
        this.view = view;
        initPlayers(board);

        List<Object> players = new LinkedList<>();
        players.add(johnHuman);
        players.add(haleyCPU);
        it = new CyclicListIterator<>(players);

        this.rule = Domain.Factory.makeGameOverRule(board);
        this.emptyValidator = new FieldIsEmptyValidator(board);
        this.alerter = new FXInputAlerter(AlertingMessages.inputAlreadyMarked);
        this.provider = Domain.Factory.makeWinningLineProvider(board);
    }

    public void onBoardClicked(int row, int col) {
        if(!isOver()) {
            Input input = new Input(row, col);
            process(input);
        }
    }

    private boolean isOver() {
        return rule.isGameOver();
    }

    private void process(Input input) {
        if(!emptyValidator.isValid(input)) {
            alerter.alert(input);
        } else {
            int row = input.getRow();
            int col = input.getColumn();
            Field f = new Field(row, col);
            playHuman(f);
            simulatePendingComputerTurns();
        }
    }

    private boolean isHuman(Object o) {
        return o instanceof GuiPlayer;
    }

    private void playHuman(Field field) {
        if(!isHuman(it.getCurrent())) {
            throw new RuntimeException("Is not human");
        }

        ((GuiPlayer) it.getCurrent()).play(field);
        it.next();
    }

    private void playComputer() {
        ((Player) it.getCurrent()).play();
        it.next();
    }

    public void onStarted() {
        simulatePendingComputerTurns();
    }

    private void simulatePendingComputerTurns() {
        while(!isHuman(it.getCurrent()) && !isOver())
            playComputer();
    }

    public void onFieldUpdated(Field field) {
        update(field);
        highlightWinningLIneIfIsProvided();
    }

    private void highlightWinningLIneIfIsProvided() {
        if(provider.hasWinningLine()) {
            Line line = provider.getWinningLine();
//            view.highlight(line);
        }
    }

    private void update(Field field) {
        if(board.isMarked(field)) {
            Mark m = board.getMarkAt(field);
            view.setField(field, m);
        } else
            view.clearField(field);
    }

}
