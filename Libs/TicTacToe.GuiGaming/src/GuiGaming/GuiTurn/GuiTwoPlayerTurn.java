package GuiGaming.GuiTurn;


import Domain.Data.Field.Field;
import GuiGaming.ValidatingInputProcessor.GuiTurn;

public class GuiTwoPlayerTurn implements GuiTurn {

    private final GuiPlayer first;
    private final GuiPlayer second;
    private GuiPlayer current;

    public GuiTwoPlayerTurn(GuiPlayer first, GuiPlayer second) {
        this.first = current = first;
        this.second = second;
    }

    public void play(Field field) {
        mark(field);
        togglePlayer();
    }

    private void mark(Field field) {
        current.mark(field);
    }

    private void togglePlayer() {
        current = current == first ? second : first;
    }
}
