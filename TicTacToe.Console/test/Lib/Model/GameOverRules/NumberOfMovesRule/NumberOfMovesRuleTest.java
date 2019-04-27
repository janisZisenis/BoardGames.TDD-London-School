package Lib.Model.GameOverRules.NumberOfMovesRule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberOfMovesRuleTest {

    private MarkedFieldCountProviderStub provider = new MarkedFieldCountProviderStub();
    private NumberOfMovesRule sut = new NumberOfMovesRule(provider);

    public NumberOfMovesRuleTest() {
        int i = 0;
    }

    @Test
    void If0FieldsAreMarked_ShouldNotBeGameOver() {
        provider.setMarkedFieldCount(0);

        boolean actual = sut.isGameOver();

        assertFalse(actual);
    }

    @Test
    void If9FieldsAreMarked_ShouldBeGameOver() {
        provider.setMarkedFieldCount(9);

        boolean actual = sut.isGameOver();

        assertTrue(actual);
    }

    @Test
    void If1FieldIsMarked_ShouldNotBeGameOver() {
        provider.setMarkedFieldCount(1);

        boolean actual = sut.isGameOver();

        assertFalse(actual);
    }

    @Test
    void If2FieldAreMarked_ShouldNotBeGameOver() {
        provider.setMarkedFieldCount(2);

        boolean actual = sut.isGameOver();

        assertFalse(actual);
    }

    @Test
    void If8FieldAreMarked_ShouldNotBeGameOver() {
        provider.setMarkedFieldCount(8);

        boolean actual = sut.isGameOver();

        assertFalse(actual);
    }

}
