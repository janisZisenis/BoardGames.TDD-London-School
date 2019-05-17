package Presentation.ConfigureViewPresenter;

public class IsStartableProviderStub implements IsStartableProvider {

    private boolean isStartable = false;

    public void setIsStartable(boolean b) {
        isStartable = b;
    }
    public boolean isStartable() {
        return isStartable;
    }

}
