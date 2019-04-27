package App;

import Lib.CLI.View.TicTacToeView.ConsoleLeaveTakerView;
import Lib.Model.Board.Board;
import Lib.Model.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.GameEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.LineEvaluator;
import Lib.Model.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Lib.Model.GameLoopImp.GameImp.Renderer;
import Lib.Model.GameLoopImp.GameLoopImp;
import Lib.Presentation.LeaveTaker.LeaveTaker;
import Lib.Presentation.LeaveTaker.LeaveTakerView;
import Lib.Presentation.LeaveTaker.WinnerProvider;
import Lib.Presentation.MarkToStringMapper.MarkToXOMapper;

public class Main {

    private static ConsoleLeaveTakerView view = new ConsoleLeaveTakerView(new MarkToXOMapper());
    private static LeaveTaker leaveTaker;

    private static WinnerProvider makeWinnerProvider(Board board) {
        HumbleLineProvider provider = new HumbleLineProvider();
        LineEvaluator evaluator = new EquallyMarkedLineEvaluator(board);
        return new GameEvaluator(provider, evaluator);
    }

    private static LeaveTaker makeLeaveTaker(LeaveTakerView view, Board board) {
        WinnerProvider provider = makeWinnerProvider(board);
        return new LeaveTaker(provider, view);
    }

    public static void main(String[] args) {
        TicTacToeFactory factory = new TicTacToeFactory();
        Board board = factory.makeBoard();

        leaveTaker = makeLeaveTaker(view, board);

        showSalutation();

        Renderer renderer = factory.makeBoardRenderer(board);
        renderer.render();

        GameLoopImp loop = factory.makeRenderingGameLoop(board);
        loop.run();

        leaveTaker.showLeaveTaking();
    }

    private static void showSalutation() {
        view.showSalutation();
    }

}
