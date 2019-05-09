package GuiGaming.GuiTurn;


import Domain.Data.Field.Field;

public class GuiTwoPlayerTurn {

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
        current.play(field);
    }

    private void togglePlayer() {
        current = current == first ? second : first;
    }
}
