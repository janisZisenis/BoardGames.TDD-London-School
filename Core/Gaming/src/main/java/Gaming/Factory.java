package Gaming;

import Gaming.GameFacade.GameFacade;
import Gaming.GameFacade.GameOverRule;
import Gaming.GameFacade.Player;
import Gaming.GameFacade.Renderer;
import Gaming.GameLoopImp.Game;
import Gaming.GameLoopImp.GameLoopImp;
import Gaming.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;
import Gaming.GameOverRules.WinnerRule.HasWinnerProvider;
import Gaming.GameOverRules.WinnerRule.WinnerRule;
import Gaming.MessagingGameLoop.GameLoop;
import Gaming.MessagingGameLoop.GameLoopMessenger;
import Gaming.MessagingGameLoop.MessagingGameLoop;
import Gaming.MultiPlayer.MultiPlayer;
import Gaming.MultiPlayer.MultiPlayerMessenger;
import Gaming.MultiPlayer.NullMultiPlayerMessenger;


public abstract class Factory {

    public static GameLoop makeGameLoop(Game game) {
        return new GameLoopImp(game);
    }

    public static GameLoop makeMessagingGameLoop(Game game, GameLoopMessenger messenger) {
        GameLoop loop = makeGameLoop(game);
        return new MessagingGameLoop(loop, messenger);
    }

    public static Game makeGame(GameOverRule rule, Player player, Renderer renderer) {
        return new GameFacade(rule, renderer, player);
    }

    public static CompositeGameOverRule makeCompositeGameOverRule() {
        return new CompositeGameOverRule();
    }

    public static GameOverRule makeWinnerRule(HasWinnerProvider provider) {
        return new WinnerRule(provider);
    }

    public static MultiPlayer makeMultiPlayer(Player first) {
        MultiPlayerMessenger messenger = new NullMultiPlayerMessenger();
        return makeMessagingMultiPlayer(first, messenger);
    }

    public static MultiPlayer makeMessagingMultiPlayer(Player first, MultiPlayerMessenger messenger) {
        return new MultiPlayer(first, messenger);
    }

}
