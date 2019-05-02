package Lib.GameOverMessageProvider.WinnerMessageProviderImp;

import Lib.Data.Mark;

public interface WinnerProvider {
    Mark getWinner();
    boolean hasWinner();
}
