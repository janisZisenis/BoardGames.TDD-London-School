package Lib.Model.TicTacToe;

import Lib.Model.GameLoopImp.GameImp.Renderer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeProceedsCorrectOrderShuntTest implements Receptionist, Renderer, GameLoop {

    private String logString = "";

    @Test
    void IfGetsProceeded__ShouldShowSalutation_RenderTheGame_RunGameLoop_ShowLeaveTaking_InCorrectOrder() {
        TicTacToe sut = new TicTacToe(this, this, this);

        sut.proceed();

        String actual = logString;
        String expected = "salute render run takeLeave ";
        assertEquals(actual, expected);
    }

    public void render() {
        logString += "render ";
    }

    public void run() {
        logString += "run ";
    }

    public void salute() {
        logString += "salute ";
    }

    public void takeLeave() {
        logString += "takeLeave ";
    }
}
