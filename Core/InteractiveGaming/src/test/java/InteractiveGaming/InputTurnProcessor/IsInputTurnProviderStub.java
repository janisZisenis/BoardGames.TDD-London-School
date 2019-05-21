package InteractiveGaming.InputTurnProcessor;

public class IsInputTurnProviderStub implements IsInputTurnProvider {

    private boolean isInputTurn = false;

    public void setIsInputTurn(boolean b) {
        this.isInputTurn = b;
    }

    public boolean isInputTurn() {
        return isInputTurn;
    }

}
