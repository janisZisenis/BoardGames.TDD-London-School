package GuiGaming.GuiTurn;


import Data.Field.Field;

public class GuiTwoPlayerTurn implements GuiTurn {

    private final GuiPlayer first;
    private final GuiPlayer second;
    private GuiPlayer current;

    public GuiTwoPlayerTurn(GuiPlayer first, GuiPlayer second) {
        this.first = current = first;
        this.second = second;
    }

    public void process(Field field) {
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
