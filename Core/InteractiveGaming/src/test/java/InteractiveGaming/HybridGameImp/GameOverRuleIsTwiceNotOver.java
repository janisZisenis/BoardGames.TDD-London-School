package InteractiveGaming.HybridGameImp;

import Gaming.GameFacade.CountingGameOverRuleStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverRuleIsTwiceNotOver {
    
    private CountingHybridPlayerSpy player = new CountingHybridPlayerSpy();
    private CountingGameOverRuleStub rule = new CountingGameOverRuleStub();
    private HybridGameImp sut = new HybridGameImp(rule, player);

    @BeforeEach
    void setUp() {
        rule.setTimesNotOver(2);
    }


    @Test
    void IfIsPlayableWithoutInputTwice_ShouldPlayTwice() {
        player.setTimesIsNotInput(2);

        sut.runToNextInputTurn();

        assertHasPlayedTimes(2);
    }

    private void assertHasPlayedTimes(int expected) {
        int actual = player.getTimesPlayedWithoutInput();
        assertEquals(expected, actual);
    }

}
