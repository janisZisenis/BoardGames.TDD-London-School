package GuiGaming.MultiHybridPlayer;

public class MultiHybridPlayer {

    public MultiHybridPlayer(HybridPlayer player) {
    }

    public boolean needsInput() {
        return false;
    }

    public class NeedsInputButWasPlayedWithout extends RuntimeException {}
    public class DoesNotNeedInputButWasPlayedWith extends RuntimeException {}
}
