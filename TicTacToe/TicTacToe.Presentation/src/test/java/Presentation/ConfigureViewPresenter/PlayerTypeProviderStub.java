package Presentation.ConfigureViewPresenter;

public class PlayerTypeProviderStub implements PlayerTypeProvider {

    private boolean hasDistinctPlayerType = false;

    public void setHasDistinctPlayerType(boolean b) {
        hasDistinctPlayerType = b;
    }
    public boolean hasDistinctPlayerType() {
        return hasDistinctPlayerType;
    }

}
