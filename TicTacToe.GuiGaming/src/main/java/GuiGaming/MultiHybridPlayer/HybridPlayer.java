package GuiGaming.MultiHybridPlayer;

public interface HybridPlayer {


    public class NeedsInputButWasPlayedWithout extends RuntimeException {}
    public class DoesNotNeedInputButWasPlayedWith extends RuntimeException {}
}
