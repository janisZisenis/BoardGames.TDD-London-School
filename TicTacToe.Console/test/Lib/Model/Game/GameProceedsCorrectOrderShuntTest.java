package Lib.Model.Game;

import Lib.Model.GameLoopImp.Renderer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameProceedsCorrectOrderShuntTest implements Receptionist, Renderer, GameLoop {

    private String logString = "";

    @Test
    void IfGetsPlayed__ShouldShowSalutation_RenderTheGame_RunGameLoop_ShowLeaveTaking_InCorrectOrder() {
        Game sut = new Game(this, this, this);

        sut.play();

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
