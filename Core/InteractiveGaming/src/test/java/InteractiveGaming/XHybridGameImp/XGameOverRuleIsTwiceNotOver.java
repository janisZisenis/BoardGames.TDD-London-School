package InteractiveGaming.XHybridGameImp;

import Gaming.GameFacade.CountingGameOverRuleStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class XGameOverRuleIsTwiceNotOver {
    
    private XHybridPlayerCountingSpy player = new XHybridPlayerCountingSpy();
    private CountingGameOverRuleStub rule = new CountingGameOverRuleStub();
    private XHybridGameImp sut = new XHybridGameImp(rule, player);

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
