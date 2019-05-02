package Lib.GameOverMessageProvider.WinnerMessageProviderImp;

import Lib.Data.Mark;
import Lib.GameOverMessageProvider.WinnerMessageProvider;

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
        Mark winner = provider.getWinner();
        return mapper.map(winner);
    }
}
