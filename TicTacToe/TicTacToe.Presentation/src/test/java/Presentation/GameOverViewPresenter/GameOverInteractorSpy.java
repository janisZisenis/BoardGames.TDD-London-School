package Presentation.GameOverViewPresenter;

public class GameOverInteractorSpy extends GameOverInteractorStub {

    private boolean didSendCancel = false;
    private boolean didSendReconfigure = false;
    private boolean didSendRestart = false;

    public boolean hasSendCancel() {
        return didSendCancel;
    }
    public void sendCancel() {
        didSendCancel = true;
    }

    public boolean hasSendReconfigure() {
        return didSendReconfigure;
    }
    public void sendReconfigure() {
        didSendReconfigure = true;
    }

    public boolean hasSendRestart() {
        return didSendRestart;
    }
    public void sendRestart() {
        didSendRestart = true;
    }
}
