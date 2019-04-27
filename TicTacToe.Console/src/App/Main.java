package App;

import Lib.CLI.View.TicTacToeView.ConsoleLeaveTakerView;
import Lib.Model.Board.Board;
import Lib.Model.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.GameEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.LineEvaluator;
import Lib.Model.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Lib.Model.GameLoop.GameImp.Renderer;
import Lib.Model.GameLoop.GameLoop;
import Lib.Presentation.LeaveTaker.LeaveTaker;
import Lib.Presentation.MarkToStringMapper.MarkToXOMapper;

public class Main {

    private static GameEvaluator gameEvaluator;
    private static ConsoleLeaveTakerView view;

    private static GameEvaluator makeTicTacToeWinningLineProvider(Board board) {
        HumbleLineProvider provider = new HumbleLineProvider();
        LineEvaluator evaluator = new EquallyMarkedLineEvaluator(board);
        return new GameEvaluator(provider, evaluator);
    }

    public static void main(String[] args) {
        TicTacToeFactory factory = new TicTacToeFactory();
        Board board = factory.makeBoard();


        gameEvaluator = makeTicTacToeWinningLineProvider(board);
        view = new ConsoleLeaveTakerView(new MarkToXOMapper());
        LeaveTaker leaveTaker = new LeaveTaker(gameEvaluator, view);

        showSalutation();
        Renderer renderer = factory.makeBoardRenderer(board);
        renderer.render();

        GameLoop loop = factory.makeRenderingGameLoop(board);
        loop.run();

        leaveTaker.showLeaveTaking();
    }

    private static void showSalutation() {
        view.showSalutation();
    }

}
