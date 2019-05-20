package Domain.NumberOfMovesRule;

import org.junit.jupiter.api.Test;

import static Gaming.GameOverRules.GameOverRuleAssertions.assertIsGameOver;
import static Gaming.GameOverRules.GameOverRuleAssertions.assertIsNotGameOver;

public class NumberOfMovesRuleTest {

    private MarkedFieldCountProviderStub provider = new MarkedFieldCountProviderStub();
    private NumberOfMovesRule sut = new NumberOfMovesRule(provider);

    @Test
    void If0FieldsAreMarked_ShouldNotBeGameOver() {
        provider.setMarkedFieldCount(0);

        assertIsNotGameOver(sut);
    }

    @Test
    void If9FieldsAreMarked_ShouldBeGameOver() {
        provider.setMarkedFieldCount(9);

        assertIsGameOver(sut);
    }

    @Test
    void If1FieldIsMarked_ShouldNotBeGameOver() {
        provider.setMarkedFieldCount(1);

        assertIsNotGameOver(sut);
    }

    @Test
    void If2FieldAreMarked_ShouldNotBeGameOver() {
        provider.setMarkedFieldCount(2);

        assertIsNotGameOver(sut);
    }

    @Test
    void If8FieldAreMarked_ShouldNotBeGameOver() {
        provider.setMarkedFieldCount(8);

        assertIsNotGameOver(sut);

    }

}
