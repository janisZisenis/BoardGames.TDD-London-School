package GuiGaming.HybridGameImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverRuleIsOnceNotOver {
    
    private HybridPlayerSpy player = new HybridPlayerSpy();
    private CountingGameOverRuleStub rule = new CountingGameOverRuleStub();
    private HybridGameImp sut = new HybridGameImp(rule, player);

    @BeforeEach
    void setUp() {
        rule.setTimesNotOver(1);
    }


    @Test
    void IfPlayerIsComputerOnce_ShouldPlayComputerOnce() {
        player.setTimesIsComputer(1);

        sut.playComputerTurns();

        assertHasPlayedTimes(1);
    }

    @Test
    void IfPlayerIsComputerTwice_ShouldPlayComputerOnce() {
        player.setTimesIsComputer(2);

        sut.playComputerTurns();

        assertHasPlayedTimes(1);
    }

    private void assertHasPlayedTimes(int expected) {
        int actual = player.getTimesPlayedComputer();
        assertEquals(expected, actual);
    }

}
