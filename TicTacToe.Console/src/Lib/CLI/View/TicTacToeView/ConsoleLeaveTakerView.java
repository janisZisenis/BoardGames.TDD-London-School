package Lib.CLI.View.TicTacToeView;

import Lib.Data.Mark;
import Lib.Presentation.LeaveTaker.LeaveTakerView;
import Lib.Presentation.MarkToStringMapper.MarkToStringMapper;

public class ConsoleLeaveTakerView implements LeaveTakerView {

    private static final String salutation = "Welcome to Game";
    private static final String draw = "Draw";
    private final MarkToStringMapper mapper;

    public ConsoleLeaveTakerView(MarkToStringMapper mapper) {
        this.mapper = mapper;
    }

    private String map(Mark m) {
        return (m == Mark.John) ? FieldSymbols.john : FieldSymbols.haley;
    }

    public void showSalutation() {
        System.out.println(salutation);
    }

    public void showWinner(Mark winner) {
        System.out.println("The Winner is " + mapper.map(winner) + "!");
    }

    public void showDraw() {
        System.out.println(draw);
    }

}
