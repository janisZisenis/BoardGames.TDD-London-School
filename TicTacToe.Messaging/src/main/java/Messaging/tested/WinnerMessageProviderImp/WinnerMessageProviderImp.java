package Messaging.tested.WinnerMessageProviderImp;

import Domain.Data.Mark;
import Domain.GameEvaluation.GameEvaluator.Api.WinnerProvider;
import Mapping.MarkToStringMapper;
import Messaging.tested.MessageProviders.GameOverMessageProvider.WinnerMessageProvider;

public class WinnerMessageProviderImp implements WinnerMessageProvider {

    private final WinnerProvider provider;
    private final MarkToStringMapper winMessagesMapper;

    public WinnerMessageProviderImp(WinnerProvider provider, MarkToStringMapper winMessagesMapper) {
        this.provider = provider;
        this.winMessagesMapper = winMessagesMapper;
    }

    public boolean hasWinner() {
        return provider.hasWinner();
    }

    public String getWinningMessage() {
        throwIfHasNoWinner();

        Mark winner = provider.getWinner();
        return winMessagesMapper.map(winner);
    }

    private void throwIfHasNoWinner() {
        if(!hasWinner())
            throw new NoWinnerAvailable();
    }
}
