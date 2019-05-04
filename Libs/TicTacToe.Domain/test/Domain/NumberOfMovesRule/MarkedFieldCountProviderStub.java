package Domain.NumberOfMovesRule;

public class MarkedFieldCountProviderStub implements MarkedFieldCountProvider {
    private int count = 0;

    public void setMarkedFieldCount(int count) {
        this.count = count;
    }

    public int getMarkedFieldCount() {
        return count;
    }
}
