package App;

import Domain.Board.Board;
import Domain.Data.Mark;
import Domain.IODeviceFactory;
import GuiGaming.HybridGuiPlayerAdapter.HybridGuiPlayerAdapter;
import GuiGaming.HybridPlayerAdapter.HybridPlayerAdapter;
import GuiGaming.MultiHybridPlayer.HybridPlayer;
import GuiGaming.MultiHybridPlayer.MultiHybridPlayer;
import GuiGaming.TicTacToeGuiPlayer.TicTacToeGuiPlayer;
import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;
import SequentialGaming.GameFacade.GameOverRule;

public class TicTacToe implements InputProcessor {

    private final MultiHybridPlayer player;
    private final GameOverRule rule;

    private HybridPlayer johnHuman;
    private HybridPlayer haleyHuman;
    private HybridPlayer johnCPU;
    private HybridPlayer haleyCPU;

    private void initPlayers(Board board) {
        johnHuman = new HybridGuiPlayerAdapter(new TicTacToeGuiPlayer(Mark.John, board));
        haleyHuman = new HybridGuiPlayerAdapter(new TicTacToeGuiPlayer(Mark.Haley, board));

        IODeviceFactory factory = new FXIODeviceFactory();
        johnCPU = new HybridPlayerAdapter(Domain.Factory.makeInvincibleComputerPlayer(Mark.John, board, factory));
        haleyCPU = new HybridPlayerAdapter(Domain.Factory.makeInvincibleComputerPlayer(Mark.Haley, board, factory));
    }

    public TicTacToe(Board board) {
        initPlayers(board);

        this.rule = Domain.Factory.makeGameOverRule(board);
        this.player = new MultiHybridPlayer(johnCPU);
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
        if(needsInput()) {
            play(input);
            run();
        }
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
