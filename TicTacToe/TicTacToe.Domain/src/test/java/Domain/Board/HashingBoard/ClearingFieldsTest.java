package Domain.Board.HashingBoard;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import org.junit.jupiter.api.Test;

public class ClearingFieldsTest {

    private HashingBoard sut = new HashingBoard();

    @Test
    void IfGetsClearedAfterOneFieldWasAdded_ShouldHave0MarkedFields() {
        Field field = new Field(0, 0);
        sut.mark(field, Mark.John);

        sut.clear();
    }

}