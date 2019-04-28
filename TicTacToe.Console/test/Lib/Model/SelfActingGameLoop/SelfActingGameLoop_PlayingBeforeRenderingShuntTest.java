package Lib.Model.SelfActingGameLoop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelfActingGameLoop_PlayingBeforeRenderingShuntTest implements Turn, Renderer {

    private CountingGameOverRuleStub rule = new CountingGameOverRuleStub();
    private SelfActingGameLoop sut = new SelfActingGameLoop(rule, this, this);

    private String logString = "";

    @Test
    void IfGameIsOverAfterOneTurn_ShouldPlayATurnBeforeRendering() {
        rule.setTimesNotGameOver(1);

        sut.run();

        assertLogStringIs("play render ");
    }

    private void assertLogStringIs(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }

    public void render() {
        logString += "render ";
    }

    public void play() {
        logString += "play ";
    }
}
