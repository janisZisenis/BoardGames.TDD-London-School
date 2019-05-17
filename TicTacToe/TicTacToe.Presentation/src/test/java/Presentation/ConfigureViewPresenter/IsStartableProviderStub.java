package Presentation.ConfigureViewPresenter;

public class PlayerTypeProviderStub implements PlayerTypeProvider {

    private boolean hasPlayerTypes = false;

    public void setHasPlayerTypes(boolean b) {
        hasPlayerTypes = b;
    }
    public boolean hasPlayerTypes() {
        return hasPlayerTypes;
    }

}
