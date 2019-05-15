package GuiGaming.HybridGameImp;

import SequentialGaming.GameFacade.CountingGameOverRuleStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverRuleIsTwiceNotOver {
    
    private HybridPlayerSpy player = new HybridPlayerSpy();
    private CountingGameOverRuleStub rule = new CountingGameOverRuleStub();
    private HybridGameImp sut = new HybridGameImp(rule, player);

    @BeforeEach
    void setUp() {
        rule.setTimesNotOver(2);
    }


    @Test
    void IfPlayerIsComputerTwice_ShouldPlayComputerTwice() {
        player.setTimesIsComputer(2);

        sut.playComputerTurns();

        assertHasPlayedTimes(2);
    }

    private void assertHasPlayedTimes(int expected) {
        int actual = player.getTimesPlayedComputer();
        assertEquals(expected, actual);
    }

}
