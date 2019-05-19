package Gaming.DelayingPlayer;

import Gaming.GameFacade.Player;

public class DelayingPlayer implements Player {

    private final Player player;
    private final int millis;

    public DelayingPlayer(Player player, int millis) {
        this.player = player;
        this.millis = millis;
    }

    public void play() {
        delay();
        player.play();
    }

    private void delay() {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
