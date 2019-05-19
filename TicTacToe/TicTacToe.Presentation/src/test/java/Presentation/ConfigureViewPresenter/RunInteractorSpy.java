package Presentation.ConfigureViewPresenter;

public class RunInteractorSpy implements RunInteractor {

    private RunRequest sentRequest;

    public RunRequest getSentRequest() {
        return sentRequest;
    }
    public void sendRun(RunRequest request) {
        sentRequest = request;
    }
}
