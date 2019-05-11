package SequentialGaming;

import SequentialGaming.GameFacade.GameFacade;
import SequentialGaming.GameFacade.GameOverRule;
import SequentialGaming.GameFacade.Renderer;
import SequentialGaming.GameFacade.Player;
import SequentialGaming.GameLoopImp.Game;
import SequentialGaming.GameLoopImp.GameLoopImp;
import SequentialGaming.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;
import SequentialGaming.GameOverRules.WinnerRule.HasWinnerProvider;
import SequentialGaming.GameOverRules.WinnerRule.WinnerRule;
import SequentialGaming.MessagingGameLoop.GameLoop;
import SequentialGaming.MessagingGameLoop.GameLoopMessenger;
import SequentialGaming.MessagingGameLoop.MessagingGameLoop;
import SequentialGaming.MultiPlayer.MultiPlayer;
import SequentialGaming.MultiPlayer.MultiPlayerMessenger;
import SequentialGaming.MultiPlayer.NullMultiPlayerMessenger;


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
