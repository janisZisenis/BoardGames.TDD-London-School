package InteractiveGaming.HybridGameImp;

import Gaming.GameFacade.CountingGameOverRuleStub;
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
    void IfIsPlayableWithoutInputOnce_ShouldPlayOnce() {
        player.setTimesPlayableWithoutInput(1);

        sut.runToNextInputTurn();

        assertHasPlayedTimes(1);
    }

    @Test
    void IfIsPlayableWithoutInputTwice_ShouldPlayOnce() {
        player.setTimesPlayableWithoutInput(2);

        sut.runToNextInputTurn();

        assertHasPlayedTimes(1);
    }

    private void assertHasPlayedTimes(int expected) {
        int actual = player.getTimesPlayedWithoutInput();
        assertEquals(expected, actual);
    }

}
