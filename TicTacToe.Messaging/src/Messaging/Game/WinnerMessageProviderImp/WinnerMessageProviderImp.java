package Messaging.Game.WinnerMessageProviderImp;

import Board.Mark;
import Lib.GameEvaluation.GameEvaluator.WinnerProvider;
import Mappers.MarkToStringMapper;
import Messaging.Game.GameOverMessageProviderImp.WinnerMessageProvider;

public class WinnerMessageProviderImp implements WinnerMessageProvider {

    private final WinnerProvider provider;
    private final MarkToStringMapper mapper;

    public WinnerMessageProviderImp(WinnerProvider provider, MarkToStringMapper mapper) {
        this.provider = provider;
        this.mapper = mapper;
    }

    public boolean hasWinner() {
        return provider.hasWinner();
    }

    public String getWinningMessage() {
        throwIfHasNoWinner();

        Mark winner = provider.getWinner();
        return mapper.map(winner);
    }

    private void throwIfHasNoWinner() {
        if(!hasWinner())
            throw new NoWinnerAvailable();
    }
}
