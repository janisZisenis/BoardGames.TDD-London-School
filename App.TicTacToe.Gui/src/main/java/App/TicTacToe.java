package App;

import Domain.Board.Board;
import Domain.Data.Mark;
import Domain.IODeviceFactory;
import GuiGaming.GuiTicTacToePlayer.GuiTicTacToePlayer;
import GuiGaming.MultiGuiPlayer.GuiPlayer;
import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;
import SequentialGaming.GameFacade.GameOverRule;
import SequentialGaming.GameFacade.Player;

public class TicTacToe implements InputProcessor {

    private final HybridPlayer player;
    private final GameOverRule rule;

    private GuiPlayer johnHuman;
    private GuiPlayer haleyHuman;
    private Player johnCPU;
    private Player haleyCPU;

    private void initPlayers(Board board) {
        johnHuman = new GuiTicTacToePlayer(Mark.John, board);
        haleyHuman = new GuiTicTacToePlayer(Mark.Haley, board);
        int i = 0;
        IODeviceFactory factory = new FXIODeviceFactory();
        johnCPU = Domain.Factory.makeInvincibleComputerPlayer(Mark.John, board, factory);
        haleyCPU = Domain.Factory.makeInvincibleComputerPlayer(Mark.Haley, board, factory);
    }

    public TicTacToe(Board board) {
        initPlayers(board);

        this.rule = Domain.Factory.makeGameOverRule(board);
        this.player = new HybridPlayer(johnCPU);
        player.add(haleyHuman);
    }

    public void process(Input input) {
        run(input);
    }

    public void start() {
        run();
    }

    //HybridLoopImp
    private void run(Input input) {
        run();
        play(input);
        run();
    }

    private void run() {
        while (!isOver() && !needsInput())
            play();
    }


    //HybridGameFacade
    private boolean needsInput() {
        return player.needsInput();
    }

    private boolean isOver() {
        return rule.isGameOver();
    }

    private void play(Input input) {
        player.play(input);
    }

    private void play() {
        player.play();
    }

}
